package org.horoyoii.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class fragment1 extends Fragment {
    FragmentCallback callback;
    String title;
    String booking;
    int grade;
    int dday; // 따로 계산해주는 알고리즘이 필요...!
    int image;
    MainActivity mainActivity;
    movie_data_class DataPackage;

    // 생성자를 통해 데이터를 받아온다.
    // 클래스화 시킨다면 더 간단하게 할 수 있다.
    public fragment1(movie_data_class DataPackage, MainActivity mainActivity) {
       this.title = DataPackage.getMovieTitle();
       this.booking = String.valueOf(DataPackage.getMovieBook());
       this.grade = DataPackage.getMovieGrade();
       this.dday = 4;
       this.image = DataPackage.getMovieImage();
       this.mainActivity = mainActivity;
       this.DataPackage = DataPackage;
    }

    @Override
    public void onAttach(Context context) { // 액티비티에 붙는 순간 호출되는 함수
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(callback !=null)
            callback = null;
    }


    ImageView frag_image;
    TextView frag_title, frag_booking, frag_grade, frag_dday;
    Button btnDetail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment1, container, false);
        frag_image = (ImageView)rootView.findViewById(R.id.frag_image);
        frag_title = (TextView)rootView.findViewById(R.id.frag_title);
        frag_booking = (TextView)rootView.findViewById(R.id.frag_booking);
        frag_grade = (TextView)rootView.findViewById(R.id.frag_grade);
        frag_dday = (TextView)rootView.findViewById(R.id.frag_dday);

        btnDetail = (Button)rootView.findViewById(R.id.frag_detail);

        frag_title.setText(this.title);
        frag_image.setImageResource(this.image);

        String gradeString = String.valueOf(grade)+"세 관람가";
        frag_grade.setText(gradeString);

        String bookingString = "예매율 : "+booking;
        frag_booking.setText(bookingString);

        String Ddays = "D-"+String.valueOf(dday);
        frag_dday.setText(Ddays);

        Button btnDetail = (Button)rootView.findViewById(R.id.frag_detail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.ShowDetailInfo(DataPackage);
            }
        });

        return rootView;
    }
}

package org.horoyoii.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowAllCommentActivity extends AppCompatActivity {
    TextView sac_movieTitle;
    ImageView sac_movieGrade;
    Button sac_btnWrite;

    ListView listView;
    commentAdapter adapter;




    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_comment);
        setTitle("한줄평 목록");

        sac_movieTitle = (TextView)findViewById(R.id.sac_MovieTitle);
        sac_movieGrade = (ImageView)findViewById(R.id.sac_MovieGrade);


        Intent intent = getIntent();
        processIntent(intent);

        sac_btnWrite = (Button)findViewById(R.id.sac_btnWrite);

        sac_btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);

                intent.putExtra("movieTitle", intent.getStringExtra("movieTitle"));
                intent.putExtra("movieGrade", intent.getIntExtra("movieGrade", 0));

                startActivityForResult(intent, 102);

            }
        });


        //====================================================================================
        // 리스트뷰 간단 목록
        //====================================================================================
        ListView listView = (ListView)findViewById(R.id.sac_showAllListView);
        adapter = new commentAdapter();

        //아이템 추가하기==================================
        adapter.addItem(new comment_item("eirc8260", "와우 정말정말 재밌었어요!! 대박입니다.",4,"10분 전",2.5));
        adapter.addItem(new comment_item("demonic3540", "적당히 재미있다. 오랜만에 보면서 숙면을 취할 수 있었다.",6,"15분 전",4.0));
        adapter.addItem(new comment_item("demonic3540", "적당히 재미있다. 오랜만에 보면서 숙면을 취할 수 있었다.",16,"30분 전",4.0));
        adapter.addItem(new comment_item("demonic3540", "적당히 재미있다. 오랜만에 보면서 숙면을 취할 수 있었다.",5,"30분 전",4.0));
        adapter.addItem(new comment_item("demonic3540", "적당히 재미있다. 오랜만에 보면서 숙면을 취할 수 있었다.",2,"60분 전",4.0));
        adapter.addItem(new comment_item("eirc8260", "와우 정말정말 재밌었어요!! 대박입니다.",4,"10분 전",2.5));
        adapter.addItem(new comment_item("eirc8260", "와우 정말정말 재밌었어요!! 대박입니다.",4,"10분 전",2.5));


        listView.setAdapter(adapter);



    }

    //=================================================================================================================

    public void processIntent(Intent intent){
        if(intent !=null){
            String movieTitle = intent.getStringExtra("movieTitle");
            int movieGrade = intent.getIntExtra("movieGrade", 0);
            sac_movieTitle.setText(movieTitle);
            switch (movieGrade) {
                case 12:
                    sac_movieGrade.setImageResource(R.drawable.ic_12);
                    break;
                case 15:
                    sac_movieGrade.setImageResource(R.drawable.ic_15);
                    break;
                case 19:
                    sac_movieGrade.setImageResource(R.drawable.ic_19);
                    break;
                case 0:
                    sac_movieGrade.setImageResource(R.drawable.ic_all);
                    break;
                default:
                    sac_movieGrade.setImageResource(R.drawable.ic_all);
                    break;
            }
        }

    }

    //======================================================================================
    class commentAdapter extends BaseAdapter {
        // 어댑터가 데이터를 관리한다.
        ArrayList<comment_item> items = new ArrayList<comment_item>();


        //====================================================================
        // generate 로 자동 생성...! (implement 항목)
        @Override
        // 데이터(아이템)의 갯수 반환
        public int getCount() {
            return items.size();
        }

        @Override
        // 해당 데이터 참조
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        // 데이터와 뷰를 연결시켜주는 실실적인 역할
        public View getView(int position, View view, ViewGroup viewGroup) {

            // 1) 부분화면을 우선 정의 - dataset_view 는 item하나의 뷰.

            comment_item_view View = null;

            // 아래의 조건문은 자연스럽게 스크롤이 내려갈 수 있도록 해준다.
            // 천개 모두 메모리에 올리는 것이 아닌 보여지는 것만 올라가도록 해줌.
            if(view == null)
                View = new comment_item_view(getApplicationContext());
            else
                View = (comment_item_view) view;

            comment_item item = items.get(position);
            View.setId(item.getID());
            View.setTime(item.getTime());
            View.setRating(item.getRating());
            View.setContent(item.getContent());
            View.setRecCount(item.getRecCount());

            return View;
        }

        //============================================
        // 외부에서 아이템을 받는 함수
        public void addItem(comment_item item){
            items.add(item);
        }

    }
}


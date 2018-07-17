package org.horoyoii.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment_detail extends Fragment {

    TextView info_movieTitle;
    ImageView info_movieGrade;
    TextView info_movieOpen;
    TextView info_movieGenreAndRun;
    TextView info_movieBook;
    RatingBar info_movieRatingBar;
    TextView info_movieRating;
    TextView info_movieAudience;
    TextView info_movieSynposis;
    TextView info_movieDirector;
    TextView info_movieActor;
    ImageView info_movieImage;
    movie_data_class DataPackage;


    //=============================================================


    Button likeButton, dislikeButton, btnWrite, btnShowAll;
    TextView likeCount, dislikeCount;

    int nLikeCount;
    int nDislikeCount;
    boolean likeState = false;
    boolean dislikeState = false;

    String movieTitle;
    int movieGrade;

    commentAdapter adapter;



    public fragment_detail(movie_data_class dataPackage) {
        DataPackage = dataPackage;
        nLikeCount = DataPackage.getMovieLike();
        nDislikeCount = DataPackage.getMovieDislike();
        movieTitle = DataPackage.getMovieTitle();
        movieGrade = DataPackage.getMovieGrade();

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);

        //====================================================================================
        //받은 정보로 화면 최기화 ###################################################3
        //====================================================================================
        info_movieTitle = (TextView)rootView.findViewById(R.id.info_movieTitle);
        info_movieGrade = (ImageView)rootView.findViewById(R.id.info_movieGrade);

        initXML(movieTitle, movieGrade);

        info_movieOpen = (TextView)rootView.findViewById(R.id.info_movieOpen);

        info_movieGenreAndRun = (TextView)rootView.findViewById(R.id.info_movieGenreAndRuntime);
        String GenAndRun = DataPackage.getMovieGrade() + " / " + String.valueOf(DataPackage.getMovieRuntime());
        info_movieGenreAndRun.setText(GenAndRun);

        info_movieBook = (TextView)rootView.findViewById(R.id.info_movieBook);
        info_movieBook.setText(String.valueOf(DataPackage.getMovieBook()));


        info_movieRatingBar = (RatingBar)rootView.findViewById(R.id.info_movieRatingBar);
        info_movieRatingBar.setRating(DataPackage.getMovieRating());


        info_movieRating = (TextView)rootView.findViewById(R.id.info_movieRating);
        info_movieRating.setText(String.valueOf(DataPackage.getMovieRating()));


        info_movieAudience = (TextView)rootView.findViewById(R.id.info_movieAudience);
        info_movieAudience.setText(String.valueOf(DataPackage.getMoiveTotalAudience()));


        info_movieSynposis = (TextView)rootView.findViewById(R.id.info_movieSynopsis);
        info_movieSynposis.setText(DataPackage.getMovieSynopsis());


        info_movieDirector = (TextView)rootView.findViewById(R.id.info_movieDirector);
        info_movieDirector.setText(DataPackage.getMovieCaptin());



        info_movieActor = (TextView)rootView.findViewById(R.id.info_movieActor);
        String Actors = DataPackage.getMovieActor1() +", "+DataPackage.getMovieActor2();

        info_movieActor.setText(Actors);

        info_movieImage = (ImageView)rootView.findViewById(R.id.info_movieImage);
        info_movieImage.setImageResource(DataPackage.getMovieImage());






        //====================================================================================
        // 좋아요, 싫어요 버튼 처리
        //====================================================================================
        likeButton = (Button)rootView.findViewById(R.id.likeButton);
        dislikeButton =(Button)rootView.findViewById(R.id.dislikeButton);
        likeCount = (TextView)rootView.findViewById(R.id.likeCount);
        likeCount.setText(String.valueOf(nLikeCount));
        dislikeCount = (TextView)rootView.findViewById(R.id.dislikeCount);
        dislikeCount.setText(String.valueOf(nDislikeCount));


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrLikeCount();
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrLikeCount();
            }
        });






        //====================================================================================
        // 리스트뷰 간단 목록
        //====================================================================================
        ListView listView = (ListView)rootView.findViewById(R.id.SimpleListView);
        adapter = new commentAdapter();

        //아이템 추가하기==================================
        adapter.addItem(new comment_item("eirc8260", "와우 정말정말 재밌었어요!! 대박입니다.",4,"10분 전",2.5));
        adapter.addItem(new comment_item("demonic3540", "적당히 재미있다. 오랜만에 보면서 숙면을 취할 수 있었다.",6,"30분 전",4.0));


        listView.setAdapter(adapter);






        //==============================================================================
        //작성하기 버튼 클릭 시
        //==============================================================================
        btnWrite = (Button)rootView.findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCommentWriteActivity(movieTitle, movieGrade);
            }
        });






        //================================================================================
        // 모두보기 버튼 클릭 시
        //================================================================================
        btnShowAll = (Button)rootView.findViewById(R.id.info_btnShowAll);
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCommentAllActivity(movieTitle, movieGrade);
            }
        });

        return rootView;
    }


    //=============================================================================================


    public void initXML(String movieTitle, int movieGrade){
        info_movieTitle.setText(movieTitle);

        switch (movieGrade) {
            case 12:
                info_movieGrade.setImageResource(R.drawable.ic_12);
                break;
            case 15:
                info_movieGrade.setImageResource(R.drawable.ic_15);
                break;
            case 19:
                info_movieGrade.setImageResource(R.drawable.ic_19);
                break;
            case 0:
                info_movieGrade.setImageResource(R.drawable.ic_all);
                break;
            default:
                info_movieGrade.setImageResource(R.drawable.ic_all);
                break;
        }
    }


    //=====================================================================================================
     //버튼 처리 함수들.....


    public void ShowCommentWriteActivity(String movieTitle, int movieGrade){
        // getActivity 이거나 context 이거나.....
        Intent intent = new Intent(getActivity(), CommentWriteActivity.class);
        intent.putExtra("movieTitle", movieTitle);
        intent.putExtra("movieGrade", movieGrade);

        startActivityForResult(intent, 101);
    }

    public void ShowCommentAllActivity(String movieTitle, int movieGrade){
        Intent intent = new Intent(getActivity(), ShowAllCommentActivity.class);
        intent.putExtra("movieTitle", movieTitle);
        intent.putExtra("movieGrade", movieGrade);

        startActivityForResult(intent, 102);
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
                View = new comment_item_view(getContext());
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





    // ===============================================================================================
    // 좋아요, 싫어요  버튼 처리
    // ===============================================================================================
    public void incrLikeCount(){
        if(!dislikeState) {
            if(!likeState) {
                nLikeCount++;
                likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
            }else{
                nLikeCount--;
                likeButton.setBackgroundResource(R.drawable.ic_thumb_up);
            }
        }else{
            nLikeCount++;
            nDislikeCount--;
            dislikeState = !dislikeState;
            likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
            dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down);
        }

        likeCount.setText(String.valueOf(nLikeCount));
        likeState = !likeState;
        dislikeCount.setText(String.valueOf(nDislikeCount));
    }

    public void decrLikeCount(){
        if(!likeState) {
            if(!dislikeState) {
                nDislikeCount++;
                dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
            }else{
                nDislikeCount--;
                dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down);
            }
        }else{
            nDislikeCount++;
            nLikeCount--;
            likeState = !likeState;
            dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
            likeButton.setBackgroundResource(R.drawable.ic_thumb_up);
        }

        dislikeCount.setText(String.valueOf(nDislikeCount));
        dislikeState = !dislikeState;
        likeCount.setText(String.valueOf(nLikeCount));
    }
    // ===============================================================================================


}

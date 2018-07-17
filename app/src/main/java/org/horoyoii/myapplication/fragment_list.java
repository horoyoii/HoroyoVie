package org.horoyoii.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_list extends Fragment {

    ViewPager viewPager;
    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)getActivity(); // MainActivity를 잡아서 내려온다.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);


        //================================================================================
        // 영화정보 추가하기
        //================================================================================

        viewPager =(ViewPager)rootView.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);


        MoviePagerAdapter adapter = new MoviePagerAdapter(getFragmentManager());


        movie_data_class package1 = new movie_data_class("군도", 15,"액션",148,27,7,3.2f,888123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image1);
        movie_data_class package2 = new movie_data_class("공조", 15,"액션",148,227,45,3.4f,428123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image2);
        movie_data_class package3 = new movie_data_class("더킹", 15,"액션",148,14,15,4.2f,8123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image3);
        movie_data_class package4 = new movie_data_class("레지던트 이블", 15,"액션",148,27,5,3.2f,814123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image4);
        movie_data_class package5 = new movie_data_class("럭키", 15,"액션",148,1423,25,1.2f,668123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image5);
        movie_data_class package6 = new movie_data_class("아수라", 15,"액션",148,7,55,2.2f,153123,18.2f,"어쩌고저쩌고....","윤종빈","하정우(도치)", "강동원(조윤)", R.drawable.image6);


        // 생성자 지정을 통해 하나의 프래그먼트 클래스에 여러 정보를 추가할 수 있다!
        // fragment1(String Title, String booking, int grade, int dday, int image)
        fragment1 fragment1 = new fragment1(package1, mainActivity);
        fragment1 fragment2 = new fragment1(package2, mainActivity);
        fragment1 fragment3 = new fragment1(package3, mainActivity);
        fragment1 fragment4 = new fragment1(package4, mainActivity);
        fragment1 fragment5 = new fragment1(package5, mainActivity);
        fragment1 fragment6 = new fragment1(package6, mainActivity);




        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);
        adapter.addItem(fragment4);
        adapter.addItem(fragment5);
        adapter.addItem(fragment6);

        viewPager.setAdapter(adapter);

        return rootView;
    }


    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();


        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int i) {
            return items.get(i);
        }

        @Override
        public int getCount() {
            return items.size();
        }


    }
}

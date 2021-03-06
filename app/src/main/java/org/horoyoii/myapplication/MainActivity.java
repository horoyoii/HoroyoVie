package org.horoyoii.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {


   // ViewPager viewPager;
    fragment_list fragment_list;
    fragment_detail fragment_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 네비게이션 바 ===================================================================
        //================================================================================
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //====================================================================================
        // replace 프래그먼트하기
        //====================================================================================
        fragment_list = new fragment_list();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_list).commit();




         //================================================================================









        // onCreate 끗
        //================================================================================
    }



    public void ShowDetailInfo(movie_data_class DataPackage){
        fragment_detail = new fragment_detail(DataPackage);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_detail).commit();
    }


    public void onCommand(String command, String data){
        //
    }


//    class MoviePagerAdapter extends FragmentStatePagerAdapter{
//        ArrayList<Fragment> items = new ArrayList<Fragment>();
//
//
//        public MoviePagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        public void addItem(Fragment item){
//            items.add(item);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            return items.get(i);
//        }
//
//        @Override
//        public int getCount() {
//            return items.size();
//        }
//
//
//    }















    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            // =================================================
            // 부자연스러운 부분....
            // ==================================================
            fragment_list = new fragment_list();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_list).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_list) {
            fragment_list = new fragment_list();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_list).commit();
        } else if (id == R.id.nav_api) {

        } else if (id == R.id.nav_book) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

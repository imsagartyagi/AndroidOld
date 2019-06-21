package com.example.sagartyagi.projects;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class FreeLancer extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager vpg;
    Toolbar tbr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_lancer);
        tbr=(Toolbar)findViewById(R.id.toolbar3);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        vpg=(ViewPager)findViewById(R.id.viewpger);
        setSupportActionBar(tbr);
        viewpagerAdapter adapter=new viewpagerAdapter(getSupportFragmentManager());
        adapter.addinfo(new CompanyProject(),"Company Projects");
        adapter.addinfo(new YourProject(),"Your Projects");
        vpg.setAdapter(adapter);
        getSupportActionBar().setTitle("FreeLancer");
        tabLayout.setupWithViewPager(vpg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufreelancer,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.refresh1){
            Intent intent =new Intent(FreeLancer.this,FreeLancer.class);
            startActivity(intent);
            Toast.makeText(FreeLancer.this,"Refresh",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.logout2){
            Intent intent =new Intent(FreeLancer.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Toast.makeText(FreeLancer.this,"Logout",Toast.LENGTH_SHORT).show();

        }

        return true;
    }

    public class viewpagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragments=new ArrayList<Fragment>();
        ArrayList<String> titles =new ArrayList<String>();

        public void addinfo(Fragment fragment,String title){
            this.fragments.add(fragment);
            this.titles.add(title);
        }

        public viewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}

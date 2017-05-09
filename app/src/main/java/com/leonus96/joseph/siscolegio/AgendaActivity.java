package com.leonus96.joseph.siscolegio;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AgendaActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout) TabLayout _tabLayout;
    @BindView(R.id.viewPager) ViewPager _viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        if(id == 1){
            toolbar.setTitle("José Alberto Alfaro López");
        }else{
            toolbar.setTitle("Génesis Michelle Alfaro López");
        }

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        _tabLayout.addTab(_tabLayout.newTab().setText("Asistencias"));
        _tabLayout.addTab(_tabLayout.newTab().setText("Calificaciones"));
        _tabLayout.addTab(_tabLayout.newTab().setText("Pagos"));
        _tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        PagerAdapter adapter = new com.leonus96.joseph.siscolegio.Adapters.PagerAdapter(getSupportFragmentManager(), _tabLayout.getTabCount());
        _viewPager.setAdapter(adapter);
        _viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(_tabLayout));

        _tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                _viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}

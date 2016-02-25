package com.example.kiran.drawablelayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
final String[] iconNames={"Ace","Add","Audio","Play"};
    final int[] icons={R.drawable.ic_ace,R.drawable.ic_add,R.drawable.ic_audio,R.drawable.ic_play};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        init();
    }
    private void init() {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawMainActivity);
        recycleViewAdapter=new RecycleViewAdapter(getApplicationContext(),iconNames,icons,drawerLayout,recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleViewAdapter);
    }
    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


}

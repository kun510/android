package com.example.hoc1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class trangchu extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewflip;
    RecyclerView recyclerView;
    NavigationView navigation;
    ListView listview;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        home();
        actionBar();
        ActionViewFlipper();
    }
    private  void ActionViewFlipper(){
        List<String> mauquangcao = new ArrayList<>();
        mauquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png");
        mauquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png");
        mauquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg");

        for (int i = 0; i<mauquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mauquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        viewflip.setFlipInterval(3000);
        viewflip.setAutoStart(true);
        //xet animation
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_anh_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_anh_out_right);
        viewflip.setInAnimation(slide_in);
        viewflip.setOutAnimation(slide_out);

    }
    private void actionBar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void home(){
        toolbar = findViewById(R.id.titlehome);
        viewflip = findViewById(R.id.viewflip);
        recyclerView = findViewById(R.id.list);
        navigation = findViewById(R.id.navigation);
        listview = findViewById(R.id.listview);
        drawerLayout = findViewById(R.id.drawerlayout);
    }
}
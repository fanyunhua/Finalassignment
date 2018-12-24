package com.fanyuhua.finalassignment.guide;

import android.content.Intent;
import android.gesture.GestureUtils;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fanyuhua.finalassignment.R;
import com.fanyuhua.finalassignment.adapter.ViewPagerAdapter;
import com.fanyuhua.finalassignment.login.ActivityLogin;
import com.fanyuhua.finalassignment.tab.user.LogisticsActivity;

import java.util.ArrayList;
import java.util.List;

import static com.fanyuhua.finalassignment.R.drawable.add1;

/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private int[] imageArray;
    private int[] imageTip;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> list;
//    private ImageView imageView1,imageView2,imageView3;
    private Button into;
    ImageView[] imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        list = new ArrayList<View>();
        LinearLayout.LayoutParams mp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        // 初始化引导图片列表
        for (int i = 0; i < imageArray.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mp);
            iv.setImageResource(imageArray[i]);
            list.add(iv);
        }
        viewPagerAdapter = new ViewPagerAdapter(list);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOnPageChangeListener(this);
        into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        imageArray = new int[]{
                R.mipmap.image_001,
                R.mipmap.image_002,
                R.mipmap.image_003
        };
        imageTip = new int[]{
                R.mipmap.tip2,
                R.mipmap.tip1,
                R.mipmap.tip1
        };
        imageView = new ImageView[3];
        imageView[0] = findViewById(R.id.im1);
        imageView[1] = findViewById(R.id.im2);
        imageView[2] = findViewById(R.id.im3);
        into = findViewById(R.id.into);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

        setImageBackground(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }
    private void setImageBackground(int sel)
    {
        for (int i = 0;i<imageArray.length;i++)
        {
            if(i==sel)
            {
                if(sel==2)
                {
                    into.setVisibility(View.VISIBLE);
                }
                else into.setVisibility(View.GONE);
                imageView[i].setBackgroundResource(R.mipmap.tip2);
            }
            else
                {
                    imageView[i].setBackgroundResource(R.mipmap.tip1);
            }
        }
    }

}

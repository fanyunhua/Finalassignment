package com.fanyuhua.finalassignment.guide;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fanyuhua.finalassignment.R;
/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private ImageView[] imageViews;
    private ImageView[] imageTipViews;
    private int[] imageArray;
    private int[] imageTip;
    private ViewGroup viewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        addImageToView();

        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem((imageViews.length)*100);
    }

    private void addImageToView() {
        imageViews = new ImageView[imageArray.length];
        for (int i = 0;i<imageArray.length;i++)
        {
            ImageView im = new ImageView(this);
            imageViews[i] = im;
            im.setBackgroundResource(imageArray[i]);
        }
        imageTipViews = new ImageView[imageArray.length];
        for (int i = 0;i<imageArray.length;i++)
        {
            ImageView im = new ImageView(this);
            imageViews[i] = im;
            if(i==0)
            {
                im.setBackgroundResource(imageTip[0]);
            }
            else
            {
                im.setBackgroundResource(imageTip[i]);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        layoutParams.leftMargin = 5;
        layoutParams.leftMargin = 5;
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        viewGroup = findViewById(R.id.viewGroup);
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
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
    private class MyAdapter extends PagerAdapter
    {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(imageViews[position%imageArray.length]);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(imageViews[position%imageArray.length],0);
            return imageViews[position%imageArray.length];
        }
    }
}

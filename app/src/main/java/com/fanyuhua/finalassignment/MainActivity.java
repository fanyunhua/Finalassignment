package com.fanyuhua.finalassignment;

import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.fanyuhua.finalassignment.tab.Add;
import com.fanyuhua.finalassignment.tab.Home;
import com.fanyuhua.finalassignment.tab.More;
import com.fanyuhua.finalassignment.tab.User;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost fragmentTabHost;

    private String[] tabTitles;
    private int[] tabImageView = {
            R.drawable.home1,
            R.drawable.more1,
            R.drawable.add1,
            R.drawable.user1
    };
    private int[] tabImageView2 =
            {
                    R.drawable.home2,
                    R.drawable.more2,
                    R.drawable.add2,
                    R.drawable.user2
            };
    private Class[] fragments = {
            Home.class,
            More.class,
            Add.class,
            User.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabTitles= new String[]
                {
                        this.getString(R.string.home),
                        this.getString(R.string.more),
                        this.getString(R.string.add),
                        this.getString(R.string.user)
                };

        fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.RealContentLL);
        initTab();
        fragmentTabHost.setOnTabChangedListener(this);

    }

    private void initTab() {
        for (int i = 0;i<tabTitles.length;i++)
        {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabTitles[i]).setIndicator(getTabView(i));
            fragmentTabHost.addTab(tabSpec,fragments[i],null);
        }
    }
    View getTabView(int i) {
//        //将xml布局转换 xml->view
        View view = LayoutInflater.from(this).inflate(R.layout.item, null);
        //找到标签布局里的控件
        //注意是view布局下的   --view--
        TextView tabTitle = (TextView) view.findViewById(R.id.tabTitle);
        ImageView tabLv = (ImageView) view.findViewById(R.id.imagetabIv);
        /* 将图片和标题填进控件 */
        tabTitle.setText(tabTitles[i]);
        if (i == 0) {
            tabTitle.setTextColor(Color.BLUE);
            tabLv.setImageResource(tabImageView2[i]);
        } else {
            tabTitle.setTextColor(Color.GRAY);
            tabLv.setImageResource(tabImageView[i]);
        }
        return view;
    }
    public void onTabChanged(String s) {
        //找到当前点击的是哪个标签
        TabWidget tabWidget = fragmentTabHost.getTabWidget();
        for (int i = 0; i < tabTitles.length; i++) {
            View view = tabWidget.getChildAt(i);
            TextView tabTitle = (TextView) view.findViewById(R.id.tabTitle);
            ImageView tabLv = (ImageView) view.findViewById(R.id.imagetabIv);
            /* 将图片和标题填进控件 */
            tabTitle.setText(tabTitles[i]);
            //判断第几个是当前点击的tab
            if (i == fragmentTabHost.getCurrentTab()) {
                tabTitle.setTextColor(Color.BLUE);
                tabLv.setImageResource(tabImageView2[i]);
            } else {
                tabTitle.setTextColor(Color.GRAY);
                tabLv.setImageResource(tabImageView[i]);
            }
        }
    }
}

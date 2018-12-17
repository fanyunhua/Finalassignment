package com.fanyuhua.finalassignment.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.fanyuhua.finalassignment.R;

/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class Home extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] price;
    private String[] name;
    private int[] image;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home,null);
        initView(view);
        setData();
        MyAdapter adapter = new MyAdapter();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        return view;
    }

    private void setData() {
        price = new String[]{
                "￥50289",
                "￥50289",
                "￥81599",
                "￥11999",
                "￥40289"
        };

        name = new String[]{
                "丽台 LEADTEK NVIDIA TESLA P100 16GB HBM2/CUDA 3584/双精4.7T/单精9.3T深度学习GPU加速卡HPC超算显卡",
                "丽台 LEADTEK NVIDIA TESLA P40 24GB GDDR5/CUDA 3840/346GB/s单精12T/INT8 22T深度学习GPU加速HPC超算显卡",
                "丽台 LEADTEK NVIDIA TESLA V100 16GB HBM2/CUDA 5120/双精7.8T/单精15.7T/人工智能深度学习GPU运算显卡",
                "丽台 LEADTEK NVIDIA TESLA M4 GDDR5 4GB/CUDA 1024/双精0.07T/单精2.2T/深度学习GPU加速HPC超算显卡",
                "丽台 LEADTEK NVIDIA TESLA P100 12GB HBM2/CUDA 3584/双精4.7T/单精9.3T深度学习GPU加速卡HPC超算显卡"
        };
        image = new int[]{
                R.drawable.icon1,
                R.drawable.icon2,
                R.drawable.icon3,
                R.drawable.icon4,
                R.drawable.icon5,
        };


    }

    private void initView(View view) {
        listView = view.findViewById(R.id.homeLV);
    }
    private class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return price.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.commodity_item,parent,false);

            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView tName = convertView.findViewById(R.id.com_nameTV);
            TextView tPrice = convertView.findViewById(R.id.priceTV);

            imageView.setImageResource(image[position]);
            tName.setText(name[position]);
            tPrice.setText(price[position]);

            return convertView;
        }
    }
}

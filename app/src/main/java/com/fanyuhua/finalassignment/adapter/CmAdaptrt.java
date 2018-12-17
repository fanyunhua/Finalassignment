package com.fanyuhua.finalassignment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanyuhua.finalassignment.R;

/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class CmAdaptrt extends BaseAdapter {
    private String[] price;
    private String[] name;
    private int[] image;
    Context context;
    public CmAdaptrt(Context context) {
    this.context = context;
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
        //此处有疑问
//        convertView = context.inflate(R.layout.commodity_item,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tName = convertView.findViewById(R.id.com_nameTV);
        TextView tPrice = convertView.findViewById(R.id.priceTV);

        imageView.setImageResource(image[position]);
        tName.setText(name[position]);
        tPrice.setText(price[position]);

        return convertView;
    }
}


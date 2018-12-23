package com.fanyuhua.finalassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanyuhua.finalassignment.R;
import com.fanyuhua.finalassignment.util.util.Cm;

public class MyCmAdapter extends ArrayAdapter<Cm> {
    LayoutInflater layoutInflater;
    private Cm cm;
    public MyCmAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cm in = getItem(position);
        if(convertView==null)
        {
            convertView = layoutInflater.inflate(R.layout.commodity_item,null,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView t1 = convertView.findViewById(R.id.com_nameTV);
        TextView t2 = convertView.findViewById(R.id.priceTV);
        TextView tt = convertView.findViewById(R.id.textView9);
        tt.setText("");
        imageView.setImageResource(in.getIm());
        t1.setText(in.getName().toString());
        t2.setText(in.getPrice()+"");
        return convertView;
    }
}

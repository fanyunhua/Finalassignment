package com.fanyuhua.finalassignment.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fanyuhua.finalassignment.R;

public class Pay extends DialogFragment {
    private int price = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pay,container);

        TextView p = view.findViewById(R.id.textView10);
        p.setText(price+"");
        Button ok = view.findViewById(R.id.OKPay);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"支付成功",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if(window!=null)
        {
            WindowManager.LayoutParams wl = window.getAttributes();
            wl.gravity = Gravity.BOTTOM;
            wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
            wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            window.setAttributes(wl);
        }
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

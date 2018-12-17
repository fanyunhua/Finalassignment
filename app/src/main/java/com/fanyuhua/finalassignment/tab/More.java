package com.fanyuhua.finalassignment.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.fanyuhua.finalassignment.R;
/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class More extends Fragment {
    private WebView webView;
    private String URL = "https://so.m.jd.com/ware/search.action?keyword=%E6%98%BE%E5%8D%A1&searchFrom=home&sf=11&as=1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.avtivity_more,null);
        webView = view.findViewById(R.id.webView);
        webView.loadUrl(URL);
        return view;
    }

}

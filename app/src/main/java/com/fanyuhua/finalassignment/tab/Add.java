package com.fanyuhua.finalassignment.tab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.fanyuhua.finalassignment.R;
import com.fanyuhua.finalassignment.adapter.MyCmAdapter;
import com.fanyuhua.finalassignment.dialog.Pay;
import com.fanyuhua.finalassignment.util.util.Cm;
import com.fanyuhua.finalassignment.util.util.DataBaseHelper;
import com.fanyuhua.finalassignment.util.util.Image;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class Add extends Fragment {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;
    private ListView listView;
    private List<Cm> list;
    private Button add;
    MyCmAdapter mc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.avtivity_add,null);
        initDataBase();
        initView(view);
        mc = new MyCmAdapter(getContext(),R.layout.commodity_item);
        deleteCm();
//        getData();
//        mc = new MyCmAdapter(getContext(),R.layout.commodity_item);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(mc);
        closeAccount();
        return view;
    }

    private void closeAccount() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cc = listView.getCount();
                Adapter a = listView.getAdapter();
                String [] priceArray;
                priceArray = new String[cc];
                for (int i = 0;i<cc;i++)
                {
                    Cm c = (Cm)a.getItem(i);
//                     priceArray[i]= c.getPrice();
                    String ac = c.getPrice();
                    priceArray[i] = new String (ac.split("￥")[1]);
//                    Toast.makeText(getContext(),""+ac.split("￥")[1],Toast.LENGTH_SHORT).show();
                }
                int [] priceData = new int[cc];
                int p = 0;
                for (int i = 0;i<cc;i++)
                {
                    priceData[i] = Integer.parseInt(priceArray[i]);
                    p = p+priceData[i];
                }
                Pay dlg = new Pay();
                dlg.setPrice(p);
                dlg.show(getFragmentManager(),"pay");
                Toast.makeText(getContext(),"共"+p+"元",Toast.LENGTH_SHORT).show();



            }
        });
    }

    private void deleteCm() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Adapter a = parent.getAdapter();
                a = listView.getAdapter();
                Cm c = (Cm) a.getItem(position);
                int  count = c.getCount();
                db.delete("car","count=?",new String[]{count+""});
                Toast.makeText(getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                getActivity().recreate();
                return true;
            }
        });
    }

    private void initView(View view) {
        listView = view.findViewById(R.id.listview_add);
        add = view.findViewById(R.id.addBTN);
    }

    private void initDataBase() {
        dataBaseHelper = new DataBaseHelper(getContext(),"shopping",null,1);
        db = dataBaseHelper.getWritableDatabase();
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    public void getData() {
        list = new ArrayList<Cm>();
        Image im = new Image();
        Cursor cursor = db.query("car",null,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            mc.add(new Cm(
                    im.imageIC[cursor.getInt(0)],
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)));
//            Toast.makeText(getContext(),cursor.getString(2)+"",Toast.LENGTH_SHORT).show();
        }
    }
}

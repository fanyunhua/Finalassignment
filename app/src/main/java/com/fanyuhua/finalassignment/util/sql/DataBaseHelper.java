package com.fanyuhua.finalassignment.util.sql;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "shopping";//数据库名字
    private static final int DB_VERSION = 1;   // 数据库版本
    private Context m_context;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //super(contex,DB_NAME,null,DB_VERSION);
        m_context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//        String sql2 = TABLE_NAME+"("+
//                FIELD_NAME+
//                " text  not null , "+FIELD_PASS+" "+"text not null)";
//        String a = String.format("create table %s",sql2);
//        sqLiteDatabase.execSQL(a);
//        Toast.makeText(m_context,"数据表1创建成功",Toast.LENGTH_SHORT).show();
        String sql3 = "create table user (name varchar(30),passwd varchar(30),phone varchar(30))";
        sqLiteDatabase.execSQL(sql3);
        //Toast.makeText(m_context,"The user database table created",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

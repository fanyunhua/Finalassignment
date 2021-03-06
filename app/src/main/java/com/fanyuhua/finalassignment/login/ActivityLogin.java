package com.fanyuhua.finalassignment.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.fanyuhua.finalassignment.MainActivity;
import com.fanyuhua.finalassignment.R;
import com.fanyuhua.finalassignment.guide.GuideActivity;
import com.fanyuhua.finalassignment.util.util.DataBaseHelper;
/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class ActivityLogin extends AppCompatActivity {
    private DataBaseHelper dataBaseHelper;
    private android.widget.EditText name,pass;
    private android.widget.Button login;
    private android.widget.TextView more,findPass,reg;
    private String name_data,pass_data;
    private CheckBox redPasswd,loginCB;
    private SharedPreferences sp,sp2;
    SharedPreferences.Editor editor,editor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("setting",0);
        sp2 = getSharedPreferences("state",0);

        editor2 = sp2.edit();
        editor = sp.edit();
        boolean count = sp2.getBoolean("count",true);
        if(count)
        {
            Intent intent = new Intent(ActivityLogin.this, GuideActivity.class);
startActivity(intent);
            editor.putString("user","");
            editor.putString("passwd","");
            editor.putBoolean("login",true);
            editor2.putBoolean("count",false);
            editor.commit();
            initView();
            initEvent();
            create_databases();
            redPAsswdCB();
            editor2.commit();
        }
        else {
            boolean a =sp.getBoolean("login",true);
            if (a)
            {
                editor.commit();
                initView();
                initEvent();
                create_databases();
                redPAsswdCB();
            }
            else {
                Intent intent = new Intent(ActivityLogin.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }

    private void redPAsswdCB() {
        String userRead = sp.getString("user","the key not found");
        String passwdRread = sp.getString("passwd","the key not found");
        name.setText(userRead);
        pass.setText(passwdRread);

    }

    private void create_databases()
    {
        dataBaseHelper = new DataBaseHelper(this,"shopping",null,1);
        //Toast.makeText(this,"数据库创建成功",Toast.LENGTH_SHORT).show();
        dataBaseHelper.getWritableDatabase();
    }
    private void initView()
    {
        name = findViewById(R.id.name_input);
        pass = findViewById(R.id.pass_input);
        login = findViewById(R.id.login);
        more = findViewById(R.id.more);
        findPass = findViewById(R.id.find_pass);
        reg = findViewById(R.id.reg);

        redPasswd = findViewById(R.id.redPassCB);
        loginCB = findViewById(R.id.loginPassCB);
    }
    private void  initEvent()
    {
        name_data = null;
        pass_data = null;
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = false;
                name_data = name.getText().toString();
                pass_data = pass.getText().toString();
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

//                Cursor cursor = db.query("user",new String[]{"name","passwd","phone"},"name",
//                        new String[]{name_data},null,null,null);
                Cursor cursor = db.query("user",
                        new String[]{"name","passwd"},
                        null,
                        null,null,null,null);
                if (getLogin(cursor,name_data,pass_data))
                {
                    Intent intent = new Intent(ActivityLogin.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(ActivityLogin.this,"The user or password is incorrectness",Toast.LENGTH_LONG).show();

                }
            }

        });

        findPass.setOnClickListener(new View.OnClickListener() {
        //找回密码
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this,FindPassActivity.class);
                startActivity(intent);
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private boolean getLogin(Cursor cursor,String name_data,String pass_data)
    {

        if (name_data.replaceAll("\\s*", "").length()>0) {
            if (pass.getText().toString().replaceAll("\\s*", "").equals(pass.getText().toString().replaceAll("\\s*", ""))) {

                if(redPasswd.isChecked())
                {
                    editor.putString("user",this.name_data);
                    editor.putString("passwd",this.pass_data);
                    editor.commit();
                }
                if(loginCB.isChecked())
                {

                    redPasswd.setChecked(true);
                    editor.putBoolean("login",false);
                    editor.commit();
                }
                while (cursor.moveToNext())
                {
                    //Toast.makeText(ActivityLogin.this,cursor.getString(0).toString()+":"+cursor.getString(1).toString(),Toast.LENGTH_LONG).show();
                    if(name_data.equals(cursor.getString(0))&&pass_data.equals(cursor.getString(1)))
                    {
                        return true;
                    }
                }
            }
            else
            {
                Toast.makeText(ActivityLogin.this,"Entered passwords differ",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(ActivityLogin.this,"Please enter the correct user name ",Toast.LENGTH_LONG).show();
        }
        return false;
    }
}

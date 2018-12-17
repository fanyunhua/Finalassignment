package com.fanyuhua.finalassignment.login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fanyuhua.finalassignment.R;
import com.fanyuhua.finalassignment.util.util.DataBaseHelper;
/**
 *
 * create by fanyuhua 2018.12.17
 *
 * */
public class RegisterActivity extends AppCompatActivity {

    private EditText name,pass1,pass2,phoneNumber;
    private Button reg;
    private String name_data = null,pass = null,phone = null;
    private DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
    }
    private void initView()
    {
        name = findViewById(R.id.name_input);
        pass1= findViewById(R.id.pass_input);
        pass2= findViewById(R.id.pass_input2);
        phoneNumber= findViewById(R.id.phone_number);
        reg = findViewById(R.id.reg2);
        dataBaseHelper = new DataBaseHelper(this,"shopping",null,1);

    }
    private void initEvent()
    {
        name_data = null;
        pass = null;
        phone = null;
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_data = name.getText().toString();
                pass = pass1.getText().toString();
                phone = phoneNumber.getText().toString();

                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                if (name_data.replaceAll("\\s*", "").length()>0) {
                    if (pass1.getText().toString().replaceAll("\\s*", "").equals(pass1.getText().toString().replaceAll("\\s*", ""))) {
                        if (phone.length() > 0) {
                            values.put("name",name_data.toString());
                            values.put("passwd",pass.toString());
                            values.put("phone",phone.toString());
                            //Toast.makeText(RegisterActivity.this,values.toString(),Toast.LENGTH_LONG).show();
                            db.insert("user",null,values);
                            Toast.makeText(RegisterActivity.this,"registered successfully ",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"Please enter the correct mobile phone number",Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Entered passwords differ",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Please enter the correct user name ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

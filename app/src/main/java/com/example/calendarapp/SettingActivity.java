package com.example.calendarapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView tv=(TextView)findViewById(R.id.editText);

        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        tv.setText(""+sp.getInt("zikyuu",0));
    }
    public void goToMain(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void save(View view){
        TextView tv=(TextView)findViewById(R.id.editText);
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        int a= Integer.parseInt(tv.getText().toString());
        editor.putInt("zikyuu",a);
        editor.apply();

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

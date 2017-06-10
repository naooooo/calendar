package com.example.calendarapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int day_id = Resources.getSystem().getIdentifier("day", "id", "android");
        findViewById(day_id).setVisibility( View.GONE );
    }

    public void goToSetting(View view){
        Intent intent=new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
    public void goToDaily(View view){
        Intent intent=new Intent(this,DailyActivity.class);
        startActivity(intent);
    }
}

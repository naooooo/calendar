package com.example.calendarapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import static com.example.calendarapp.R.id.datePicker;

public class MainActivity extends AppCompatActivity {
    Calendar cal;
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
        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        int year = dp.getYear();//年を取得
        int month = dp.getMonth();//月を取得
        int day = dp.getDayOfMonth();//日を取得
        intent.putExtra("DAY",day);
        intent.putExtra("MONTH",month+1);
        intent.putExtra("YEAR",year);
        startActivity(intent);
    }
    public void receivedData(View view){
        Intent intent=getIntent();
        Calendar cal = (Calendar) intent.getSerializableExtra("Cal");
        if(cal!=null) {
            System.out.println("" + cal.getYear() + "年" + cal.getMonth() + "月" + cal.getDay() + "日" + cal.getSh() + "：" + cal.getSm() + "〜" + cal.getFh() + "：" + cal.getFm());
        }
    }
    public void cal(View view) {

    }
}

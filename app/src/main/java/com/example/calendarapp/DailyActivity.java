package com.example.calendarapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class DailyActivity extends AppCompatActivity {
    int year,month,day;
    private Calendar cal;
    SetOfCal soc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        soc=new SetOfCal();
        Intent intent = getIntent();
        day=intent.getIntExtra("DAY",0);
        month=intent.getIntExtra("MONTH",0);
        year=intent.getIntExtra("YEAR",0);
        //TextView textView=new TextView(this);
        TextView textView=(TextView)findViewById(R.id.textView6);
        textView.setTextSize(30);
        textView.setText(year+"年"+month+"月"+day+"日");
        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_daily);
        //layout.addView(textView);
    }
    public void goToMain(View view){
        SetOfCal calendar=(SetOfCal)SaveData.load(this);
        TextView textView=(TextView)findViewById(R.id.textView6);
        textView.setTextSize(30);
        //textView.setText(""+calendar.getSh());
        //System.out.print("saved");
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void save(View view){
        int startH,startM,finishH,finishM;
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        TimePicker timePicker2=(TimePicker)findViewById(R.id.timePicker2);
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            startH = timePicker.getHour();
            startM = timePicker.getMinute();
            finishH = timePicker2.getHour();
            finishM = timePicker2.getMinute();
        } else {
            startH = timePicker.getCurrentHour();
            startM = timePicker.getCurrentMinute();
            finishH = timePicker2.getCurrentHour();
            finishM = timePicker2.getCurrentMinute();
        }
        Calendar calendar=new Calendar(year,month,day,startH,startM,finishH,finishM);
        //soc.update(calendar);
        //SaveData.save(this,soc);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("cal",calendar);
        startActivity(intent);
    }
}

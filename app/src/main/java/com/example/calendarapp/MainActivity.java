package com.example.calendarapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private SetOfCal soc=new SetOfCal();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetOfCal tmp=SaveData.load(this);
        if(tmp!=null)soc=tmp;

        //初期化
        //soc.clear();SaveData.save(this,soc);

        Intent intent=getIntent();
        if(intent!=null&&soc!=null) {
            Calendar cal = (Calendar) intent.getSerializableExtra("cal");
            soc.update(cal);
            SaveData.save(this, soc);
            TextView textView = (TextView) findViewById(R.id.calView);
            textView.setText("");
            for (int i = soc.cals.size() - 1; i >= 0; i--) {
                if (soc.cals.get(i) != null) {
                    String c = soc.cals.get(i).toString();
                    textView.append(c + "\n");
                    textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                }
            }
        }
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
    public void showCal(View view) {
        Intent intent=getIntent();
        Calendar cal=(Calendar)intent.getSerializableExtra("cal");
        if(soc!=null) {
            soc.update(cal);
            SaveData.save(this, soc);
            EditText et = (EditText) findViewById(R.id.editNumberText);
            et.setText(" " + keisan());
            et.setTextSize(30);
        }
    }
    private int keisan(){
        Model model=new Model();
        model.setSoc(soc);
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        int z=sp.getInt("zikyuu",1000);
        model.setZikyuu(z);

        DatePicker dp=(DatePicker)findViewById(R.id.datePickerSpinner);
        int year=dp.getYear();
        int month=dp.getMonth()+1;
        return model.oneMonthSala(year,month);
    }
}

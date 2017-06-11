package com.example.calendarapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import static com.example.calendarapp.R.id.datePicker;

public class MainActivity extends AppCompatActivity {
    Calendar cal;
    SetOfCal soc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*SharedPreferences sp = getSharedPreferences("onetime", Context.MODE_PRIVATE);
        if(sp.getInt("one", 0) == 0){
            System.out.println("helll------------");
            soc=new SetOfCal();
            sp.edit().putInt("one", 1).commit();
        }*/

        soc=new SetOfCal();
        soc=SaveData.load(this);

        //初期化
        //soc.clear();SaveData.save(this,soc);

        //if(soc==null)soc=new SetOfCal();
        Intent intent=getIntent();
        Calendar cal=(Calendar)intent.getSerializableExtra("cal");
        System.out.println(soc.cals);
        soc.update(cal);
        SaveData.save(this,soc);
        TextView textView=(TextView)findViewById(R.id.calView);
        textView.setText("");
        System.out.println(soc.cals);
        for (int i = soc.cals.size()-1;i>=0; i--){
            //Calendar a=soc.cals.get(i);System.out.println("#####"+soc.cals.size());
            //String s=a.toString();System.out.println(s);
            if(soc.cals.get(i)!=null) {
                String country = soc.cals.get(i).toString();
                textView.append(country + "\n");
                textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                System.out.println(country);
            }
        }
        /*if(AppLaunchChecker.hasStartedFromLauncher(this)){

            Log.d("AppLaunchChecker","2回目以降");
        } else {

            Log.d("AppLaunchChecker","はじめてアプリを起動した");
        }
        AppLaunchChecker.onActivityCreate(this);*/
        //soc=new SetOfCal();
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
        DatePicker dp=(DatePicker)findViewById(R.id.datePickerSpinner);
        int year=dp.getYear();
        int month=dp.getMonth();
        Intent intent=getIntent();
        Calendar cal = (Calendar) intent.getSerializableExtra("Cal");
        if(cal!=null) {
            System.out.println("" + cal.getYear() + "年" + cal.getMonth() + "月" + cal.getDay() + "日" + cal.getSh() + "：" + cal.getSm() + "〜" + cal.getFh() + "：" + cal.getFm());
        }
    }
    public void showCal(View view) {
        Intent intent=getIntent();
        Calendar cal=(Calendar)intent.getSerializableExtra("cal");
        soc.update(cal);
        SaveData.save(this,soc);
        TextView textView=(TextView)findViewById(R.id.calView);
        textView.setText("");
        for (int i = soc.cals.size()-1;i>=0 ; i--){
            if(soc.cals.get(i)!=null) {
                String country = soc.cals.get(i).toString();
                textView.append(country+"\n");
                System.out.println(country);
            }
        }
        EditText et=(EditText)findViewById(R.id.editNumberText);
        et.setText(" "+keisan());
        et.setTextSize(30);
        /*DatePicker dp=(DatePicker)findViewById(R.id.datePickerSpinner);
        int year=dp.getYear();
        int month=dp.getMonth();*/
    }
    public int keisan(){
        Model model=new Model();
        model.setSoc(soc);
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        int z=sp.getInt("zikyuu",1000);
        model.setZikyuu(z);

        DatePicker dp=(DatePicker)findViewById(R.id.datePickerSpinner);
        int year=dp.getYear();
        int month=dp.getMonth()+1;
        System.out.println(soc.cals);
        return model.oneMonthSala(year,month);
        //return 100;
    }
}

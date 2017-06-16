package com.example.calendarapp;

import java.io.Serializable;

/**
 * Created by takazawa on 2017/06/11.
 */

public class Calendar implements Serializable {
    int year,month,day;
    int sh,sm,fh,fm;
    public Calendar(int year,int month,int day,int sh,int sm,int fh,int fm){
        this.year=year;
        this.month=month;
        this.day=day;
        this.sh=sh;
        this.sm=sm;
        this.fh=fh;
        this.fm=fm;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getSh(){
        return sh;
    }
    public int getSm(){
        return sm;
    }
    public int getFh(){
        return fh;
    }
    public int getFm(){
        return fm;
    }
    public void setYear(int year){this.year=year;}
    public void setMonth(int month){this.month=month;}
    public void setDay(int day){this.day=day;}
    public void setSh(int sh){this.sh=sh;}
    public void setSm(int sm){this.sm=sm;}
    public void setFh(int fh){this.fh=fh;}
    public void setFm(int fm){this.fm=fm;}
    public boolean equals(Object obj){
        int year1=((Calendar)obj).getYear();
        int month1=((Calendar)obj).getMonth();
        int day1=((Calendar)obj).getDay();
        if(year==year1&&month==month1&&day==day1)return true;
        else return false;
    }
    public String toString(){
        return String.format("%02d年%02d月%02d日 %02d:%02d〜%02d:%02d",year,month,day,sh,sm,fh,fm);
    }
}

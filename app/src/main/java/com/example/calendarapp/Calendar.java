package com.example.calendarapp;

import java.io.Serializable;
import java.util.Date;

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
    public void setYear(){this.year=year;}
    public void setMonth(){this.month=month;}
    public void setDay(){this.day=day;}
    public void setSh(){this.sh=sh;}
    public void setSm(){this.sm=sm;}
    public void setFh(){this.fh=fh;}
    public void setFm(){this.fm=fm;}
    public boolean equals(Object obj){
        int year1=((Calendar)obj).getYear();
        int month1=((Calendar)obj).getMonth();
        int day1=((Calendar)obj).getDay();
        System.out.println(this+"..."+obj);
        if(year==year1&&month==month1&&day==day1)return true;
        else return false;
    }
    public String toString(){
        return ""+year+"年"+month+"月"+day+"日"+sh+"："+sm+"〜"+fh+"："+fm;
    }
}

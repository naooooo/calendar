package com.example.calendarapp;


/**
 * Created by takazawa on 2017/06/11.
 */

public class Model{
    SetOfCal soc;
    int zikyuu;
    public void setSoc(SetOfCal soc){this.soc=soc;}
    public int DaySala(int year,int month,int day){
        Calendar c=new Calendar(year,month,day,0,0,0,0);
        int index=soc.cals.indexOf(c);
        if(index!=-1) {
            Calendar cal = soc.cals.get(index);
            int sh = cal.getSh();
            int sm = cal.getSm();
            int fh = cal.getFh();
            int fm = cal.getFm();
            return ((fh - sh) * 60 + fm - sm) * zikyuu/60;
        }
        return 0;//バイトが入っていない
    }
    public int oneMonthSala(int year,int month){
        int sum=0;
        for(int i=1;i<32;i++) {
            sum+=DaySala(year, month, i);
        }
        return sum;
    }
    public void setZikyuu(int z){
        zikyuu=z;
    }
}

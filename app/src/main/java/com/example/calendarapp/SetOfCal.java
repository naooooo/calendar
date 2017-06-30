package com.example.calendarapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by takazawa on 2017/06/11.
 */

public class SetOfCal implements Serializable{
    ArrayList<Calendar>cals=new ArrayList<>();
    public void update(Calendar cal){
        if(cal!=null) {
            int index = cals.indexOf(cal);//データがあるインデックス
            if (index == -1) cals.add(cal);
            else cals.set(index, cal);
        }
    }
    public void clear(){
        cals.clear();
    }
}

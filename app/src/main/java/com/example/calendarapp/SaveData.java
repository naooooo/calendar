package com.example.calendarapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Created by takazawa on 2017/06/11.
 */

public class SaveData {
    static String fn="save";
    public static void save(Context context,SetOfCal cals){
        try{
            ObjectOutputStream out=new ObjectOutputStream(
                    context.openFileOutput(fn, Context.MODE_PRIVATE));
            out.writeObject(cals);
            out.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static SetOfCal load(Context context){
        SetOfCal cal = null;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    context.openFileInput(fn)
            );
            cal = (SetOfCal)in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cal;
    }
}

package com.example.jeonjin_il.mysecondapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2016. 12. 27..
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE WATERLIST ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT ,capacity INTEGER, percentage INTEGER );");
        db.execSQL("CREATE TABLE HISTORY ( id INTEGER PRIMARY KEY AUTOINCREMENT , water_id INTEGER , day TEXT , time TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void init(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WATERLIST ", null);
        if( !cursor.moveToNext()){
            db.execSQL("INSERT INTO WATERLIST VALUES(null,'나의물잔' ,200 , 100);");
            db.execSQL("INSERT INTO WATERLIST VALUES(null,'생수한통' ,500 , 100);");
            db.execSQL("INSERT INTO WATERLIST VALUES(null,'커피' ,500 , -50);");
            db.execSQL("INSERT INTO WATERLIST VALUES(null,'주스' ,300 , 80);");
            db.execSQL("INSERT INTO WATERLIST VALUES(null,'우유' ,200 , 80);");

            db.close();
        }
    }

    public void insert_history(int water_id,String day,String time){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO HISTORY VALUES(null,"+water_id+" ,'" + day + "' , '"+time+"');");
        db.close();
    }
    public void delete_history(int id){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("DELETE FROM HISTORY WHERE id='"+id+"';");
        db.close();
    }


    public void changeWater(int id , String name,int num){
        //id 는 1번부터 시작임
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("UPDATE WATERLIST  SET name = '"+name+"', capacity = '"+num+"' WHERE id='"+id+"'");

    }

    public ArrayList<WaterList> getDatas(String day){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT W.id,W.name,W.capacity,W.percentage,H.day,H.time ,H.id" +
                " FROM HISTORY AS H, WATERLIST AS W WHERE H.water_id = W.id AND H.day='" + day+"' ", null);

        ArrayList<WaterList> ret = new ArrayList<WaterList>();
        while(cursor.moveToNext()){
            WaterList temp = new WaterList();
            temp.setWater_id(cursor.getInt(0));
            temp.setName(cursor.getString(1));
            temp.setCapacity(cursor.getInt(2));
            temp.setPercentage(cursor.getInt(3));
            temp.setDay(cursor.getString(4));
            temp.setTime(cursor.getString(5));
            temp.setId(cursor.getInt(6));
            ret.add(temp);

        }
        return ret;
    }

    public String getWaterListString(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM WATERLIST WHERE id ='"+id+"' ", null);

        cursor.moveToNext();
        String ret = cursor.getString(0);
        db.close();

        return ret;
    }

    public int getWaterListInt(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT capacity FROM WATERLIST WHERE id ='"+id+"' ", null);

        cursor.moveToNext();
        int ret = cursor.getInt(0);
        db.close();

        return ret;
    }
}
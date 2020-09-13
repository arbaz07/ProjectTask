package com.example.projecttask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, "app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table user(name text, email text primary key, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
    }

    // Inserting

    public boolean insert(String name, String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Email",email);
        contentValues.put("Password",password);
        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if (ins==-1){
            return false;
        }else {
            return true;
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor =null;

        if (sqLiteDatabase != null){
            cursor = sqLiteDatabase.rawQuery(query,null);
        }
        return cursor;
    }

    public Boolean update(String name, String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email",email);
        sqLiteDatabase.update("user", contentValues,"email=?",new String[]{String.valueOf(email)});
        return true;
    }

    void updataData(String name, String email){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);

        long result = sqLiteDatabase.update("user", contentValues, "Email = ?", new String[]{email});
        if (result == -1){
            Toast.makeText(context,"Not Success",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }
    }
}

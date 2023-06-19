package com.example.demau.repo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.demau.repo.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB extends SQLiteOpenHelper {
    private static final String dbname = "final";
    private static final int version = 1;

    private static final String tableName = "student";
    private static final String keyID = "id";
    private static final String keyName = "name";
    private static final String keyDOB = "dob";
    private static final String keyHome = "home";
    private static final String keyYear = "year";


    public StudentDB(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createStudentTable = String.format("create table %s(%s integer primary key autoincrement, %s text , %s text , %s text , %s text )",
                tableName,
                keyID,
                keyName,
                keyDOB,
                keyHome,
                keyYear);

        sqLiteDatabase.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = String.format("delete table if exists %s ", tableName);
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(keyName,student.getName());
        val.put(keyDOB,student.getDob());
        val.put(keyHome,student.getHome());
        val.put(keyYear,student.getYear());

        db.insert(tableName, null, val);
        db.close();
        System.out.println("Student added "+ student);
    }

    public List<String> getAllStudent(){
        List<String> students = new ArrayList<>();
        String query = "Select * from "+ tableName;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.rawQuery(query,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Student s=new Student(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)
            );
            students.add(s.toString());
            cursor.moveToNext();
        }

        return students;
    }

    public void deleteAllStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Delete FROM "+ tableName;

        db.execSQL(query);
        db.close();
    }
}

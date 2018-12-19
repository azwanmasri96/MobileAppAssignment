package com.example.user.mobdevassignment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import com.example.user.mobdevassignment.Model.Engineer;
import com.example.user.mobdevassignment.Model.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="users.db";
    private static final String TABLE_NAME="users";
    private static final String COLUMN_USERNAME="Username";
    private static final String COLUMN_EMAIL="Email";
    private static final String COLUMN_PW="Password";
    private static final String COLUMN_MOBNUM="MobNum";
    private static final String COLUMN_AGE="Age";
    private static final String COLUMN_GENDER="Gender";
    private static final String COLUMN_OCCUPATION="Occupation";

    private static final String TABLE_NAME2="engineers";
    private static final String COLUMN_USERNAME2="Username";
    private static final String COLUMN_EMAIL2="Email";
    private static final String COLUMN_MOBNUM2="MobNum";
    private static final String COLUMN_ADDRESS2="Address";
    private static final String COLUMN_GENDER2="Gender";
    private static final String COLUMN_AGE2="0";
    private static final String COLUMN_OCCUPATION2="Occupation";
    private static final String COLUMN_EXPERIENCE2="Experience";
    private static final String COLUMN_PW2="Password";
    private static final String COLUMN_IDCARD="IdType";
    private static final String COLUMN_IDNUM="IdNum";
    //private static final String COLUMN_IDPIC="Bitmap";

    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table users(username text primary key not null,"+
            "email text not null, pw text not null,mobnum text not null, age int, gender text not null, occupation text not null);";
    private static final String TABLE_CREATE_ENG="create table engineers(username2 text primary key not null,"+
            "email2 text not null, mobnum2 text not null, address2 text not null, gender2 text not null, age2 int, occupation2 text not null,"+
            "experience2 text not null, pw2 text not null, idcard text not null, idnum text not null);";
//    private static final String TABLE_CREATE_ENG="create table engineers(username2 text primary key not null,"+
//            "email2 text not null, mobnum2 text not null, address2 text not null, gender2 text not null, age2 int, occupation2 text not null,"+
//            "experience2 text not null, pw2 text not null, idcard text not null, idnum text not null, idpic bitmap);";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_ENG);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        this.onCreate(db);

    }

    public boolean deleteDatabase(Context context){
        return context.deleteDatabase(DATABASE_NAME);
    }

    public void insertUser(User u){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,u.getUsername());
        values.put(COLUMN_EMAIL,u.getEmail());
        values.put(COLUMN_PW,u.getPassword());
        values.put(COLUMN_MOBNUM,u.getMobileNum());
        values.put(COLUMN_AGE,u.getAge());
        values.put(COLUMN_GENDER,u.getGender());
        values.put(COLUMN_OCCUPATION,u.getOccupation());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void insertEngineer(Engineer e){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME2,e.getUsername());
        values.put(COLUMN_EMAIL2,e.getEmail());
        values.put(COLUMN_MOBNUM2,e.getMobileNum());
        values.put(COLUMN_ADDRESS2,e.getAddress());
        values.put(COLUMN_GENDER2,e.getGender());
        values.put(COLUMN_AGE2,e.getAge());
        values.put(COLUMN_OCCUPATION2,e.getOccupation());
        values.put(COLUMN_EXPERIENCE2,e.getExperience());
        values.put(COLUMN_PW2,e.getPassword());
        values.put(COLUMN_IDCARD,e.getIdcard());
        values.put(COLUMN_IDNUM,e.getIdnum());
        //values.put(COLUMN_IDPIC,e.getIdpic());

        db.insert(TABLE_NAME2,null,values);
        db.close();
    }

    public String searchPass(String uname){
        db=this.getReadableDatabase();
        String query="select 'Username', 'Password' from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String un,pw;
        pw="not found";
        if(cursor.moveToFirst()){
            do{
                un=cursor.getString(0);
                if(un.equals(uname)){
                    pw=cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return pw;
    }

    public String searchPass2(String ename){
        db=this.getReadableDatabase();
        String query="select 'Username', 'Password' from "+TABLE_NAME2;
        Cursor cursor=db.rawQuery(query,null);
        String un,pw;
        pw="not found";
        if(cursor.moveToFirst()){
            do{
                un=cursor.getString(0);
                if(un.equals(ename)){
                    pw=cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return pw;
    }
}

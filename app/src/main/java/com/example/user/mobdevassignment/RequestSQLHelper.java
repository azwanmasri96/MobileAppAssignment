package com.example.user.mobdevassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RequestSQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + RequestContract.User.TABLE_NAME + "(" + RequestContract.User.COLUMN_PHONE + " TEXT," + RequestContract.User.COLUMN_CASE_ID + " TEXT," + RequestContract.User.COLUMN_CONDITION + " TEXT," + RequestContract.User.COLUMN_MODEL + " TEXT," + RequestContract.User.COLUMN_PROBLEM + " TEXT," + RequestContract.User.COLUMN_UNIVERSITY + " TEXT)";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + RequestContract.User.TABLE_NAME;
    private String[] allColumn = {
            RequestContract.User.COLUMN_UNIVERSITY,
            RequestContract.User.COLUMN_PHONE,
            RequestContract.User.COLUMN_MODEL,
            RequestContract.User.COLUMN_PROBLEM,
            RequestContract.User.COLUMN_CONDITION,
            RequestContract.User.COLUMN_CASE_ID
    };

    public RequestSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    //Add a new record
    public void insertRequest(RequestRecord requestRecord){
        //Prepare record
        ContentValues values = new ContentValues();
        values.put(RequestContract.User.COLUMN_PHONE, requestRecord.getPhone());
        values.put(RequestContract.User.COLUMN_UNIVERSITY, requestRecord.getUniversity());
        values.put(RequestContract.User.COLUMN_PROBLEM, requestRecord.getProblem());
        values.put(RequestContract.User.COLUMN_MODEL, requestRecord.getModel());
        values.put(RequestContract.User.COLUMN_CASE_ID, requestRecord.getCaseID());
        values.put(RequestContract.User.COLUMN_CONDITION, "Not Active");

        //Insert a row
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(RequestContract.User.TABLE_NAME, null, values);

        //Close database connection
        database.close();
    }

    public List<RequestRecord> getAllUsers(){
        List<RequestRecord> records = new ArrayList<RequestRecord>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(RequestContract.User.TABLE_NAME, allColumn , null, null, null, null, null); cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            RequestRecord requestRecord = new RequestRecord();
            requestRecord.setCaseID(cursor.getString(0));
            requestRecord.setCondition(cursor.getString(1));
            requestRecord.setProblem(cursor.getString(2));
            records.add(requestRecord); cursor.moveToNext();
        }

        return records;
    }
}

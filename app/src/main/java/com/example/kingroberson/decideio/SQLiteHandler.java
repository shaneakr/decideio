package com.example.kingroberson.decideio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    private static SQLiteHandler dbHandler;
    private static SQLiteDatabase dbHandlerWrite;
    private static SQLiteDatabase dbHandlerRead;

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "android_api.db";

    // Login table name
    private static final String TABLE_QUESTION = "question";
    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "name";
    private static final String KEY_ANSWER1 = "answer1";
    private static final String KEY_ANSWER2 = "answer2";
    private static final String KEY_ANSWER3 = "answer3";


    // ensure only one instance of sqlite handler exists at any one time
    public static synchronized SQLiteHandler getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.

        if (dbHandler == null) {

            // this is the line where the database
            // itself is created

            dbHandler = new SQLiteHandler(context.getApplicationContext());

            dbHandlerWrite = dbHandler.getWritableDatabase();
            dbHandlerRead = dbHandler.getReadableDatabase();

        }

        return dbHandler;
    }

    public static void closeDB() {

        dbHandler.close();

        if (dbHandlerRead != null)
            dbHandlerRead.close();

        if (dbHandlerWrite != null)
            dbHandlerWrite.close();

    }

    private SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_QUESTION + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_QUESTION + " TEXT,"
                + KEY_ANSWER1 + " TEXT,"
                + KEY_ANSWER2 + " TEXT,"
                + KEY_ANSWER3 + " TEXT)";

        db.execSQL(CREATE_QUESTION_TABLE);

    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        // Create tables again
        onCreate(db);
    }

    public void deleteAllTables (){

        // Drop older table if existed
        dbHandlerWrite.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

    }


    /**
     * Storing user details in database
     */
    public void addQuestion(String question, String answer1, String answer2, String answer3) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question);
        values.put(KEY_ANSWER1, answer1);
        values.put(KEY_ANSWER2, answer2);
        values.put(KEY_ANSWER3, answer3);

        long id = dbHandlerWrite.insert(TABLE_QUESTION, null, values);

        Log.d(TAG, "New question inserted into sqlite: " + String.valueOf(id));

    }

    public String getAllQuestions(){

        boolean value = false;

        JSONArray questions = new JSONArray();
        JSONObject ques = null;

        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;

        Cursor cursor = dbHandlerRead.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        for(int i = 0; i<cursor.getCount();i++){
            try {
                Log.e("Data "+i, cursor.getString(1));
                ques = new JSONObject();
                ques.put("question", cursor.getString(1));
                ques.put("answer1", cursor.getString(2));
                ques.put("answer2", cursor.getString(3));
                ques.put("answer3", cursor.getString(4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            questions.put(ques);
            cursor.moveToNext();
        }
        Log.e("JSON", "{\"questions\":"+questions.toString()+"}");
        return "{\"questions\":"+questions.toString()+"}";
    }

    /**
     * Re create database Delete all tables and create them again
     */
    public void deleteQuestions() {

        // Delete All Rows
        //db.delete(TABLE_QUESTION, null, null);
        dbHandlerWrite.execSQL("delete from " + TABLE_QUESTION);


        Log.d(TAG, "Deleted all questions info from sqlite");
    }


}
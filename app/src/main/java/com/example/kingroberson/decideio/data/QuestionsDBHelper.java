package com.example.kingroberson.decideio.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kingroberson on 3/16/17.
 */

public class QuestionsDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "realQuestions.db";
    private static final int DATABASE_VERSION = 1;

    public QuestionsDBHelper (Context context){

        super(context,DATABASE_NAME, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + QuestionsContract.QuestionEntry.TABLE_NAME + " ("
                + QuestionsContract.QuestionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QuestionsContract.QuestionEntry.QUESTION + " TEXT NOT NULL, "
                + QuestionsContract.QuestionEntry.ANSWER1 + " TEXT, "
                + QuestionsContract.QuestionEntry.ANSWER2+ " INTEGER NOT NULL, "
                + QuestionsContract.QuestionEntry.ANSWER3 + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.kingroberson.decideio.data;

import android.provider.BaseColumns;

/**
 * Created by kingroberson on 3/16/17.
 */

public final class QuestionsContract {

private QuestionsContract() {}
    public static final class QuestionEntry implements BaseColumns {

        public final static String TABLE_NAME = "realQuestions";

        public final static String _ID = BaseColumns._ID;
        public final static String QUESTION = "question1";
        public final static String ANSWER1 = "answer1";
        public final static String ANSWER2 = "answer2";
        public final static String ANSWER3 = "answer3";
    }


}

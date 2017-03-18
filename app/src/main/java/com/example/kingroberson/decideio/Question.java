package com.example.kingroberson.decideio;

import com.orm.SugarRecord;

/**
 * Created by kingroberson on 3/17/17.
 */

public class Question extends SugarRecord {

    String question;
    String answer1;
    String answer2;
    String answer3;

    public Question(){
    }

    public Question(String question, String answer1, String answer2, String answer3){
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

}

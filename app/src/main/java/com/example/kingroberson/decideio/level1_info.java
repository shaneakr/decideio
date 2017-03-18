package com.example.kingroberson.decideio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class level1_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_info);
    }
    public void openLearn(View view) {
        Intent i = new Intent(this, Learn.class);
        startActivity(i);
    }
}

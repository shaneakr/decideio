package com.example.kingroberson.decideio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* try{

            //creating the database object
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("newQuestions",MODE_PRIVATE,null);
            //creating the table if it doesnt exist with column names and types
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newQuestions (question VARCHAR, answer1 VARCHAR, answer2 VARCHAR, answer3 VARCHAR, id INTEGER PRIMARY KEY)");
            //inserting data in that database
            myDatabase.execSQL("INSERT INTO newQuestions (question, answer1, answer2, answer3) VALUES ('Your boss asks you in the hallway','Yes', 'let me get back to you','freeze up')");
            myDatabase.execSQL("INSERT INTO newQuestions (question, answer1, answer2, answer3) VALUES ('You see someone in a coffee shop using a product you built you feel...', 'ecstatic','scared','not sure')");

            //Loop through the results of a particular query and do something with them
            //may have to change null to a method to stop the query if its too large
            Cursor c = myDatabase.rawQuery("SELECT * FROM newQuestions", null);

            int questionIndex = c.getColumnIndex("question");
            int answer1Index = c.getColumnIndex("answer1");
            int answer2Index = c.getColumnIndex("answer2");
            int answer3Index = c.getColumnIndex("answer3");
            int idIndex = c.getColumnIndex("id");


            //take cursor and move to the first result
            c.moveToFirst();

            Log.i("before", "before");

            //keep looping thru results as long as c is not null
            while (c!= null){
                Log.i("question",c.getString(questionIndex));
                Log.i("answer1",c.getString(answer1Index));
                Log.i("answer2",c.getString(answer2Index));
                Log.i("answer3",c.getString(answer3Index));
                Log.i("id",Integer.toString(c.getInt(idIndex)));
                c.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

*/
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void softwareEng(View view) {
        Intent i = new Intent(this, basic_fact.class);
        startActivity(i);
    }

}

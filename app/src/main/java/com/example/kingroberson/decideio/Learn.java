package com.example.kingroberson.decideio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kingroberson.decideio.data.QuestionsContract;
import com.example.kingroberson.decideio.data.QuestionsDBHelper;


public class Learn extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


        QuestionsDBHelper mQuestionsDBHelper = new QuestionsDBHelper(this);
        SQLiteDatabase db = mQuestionsDBHelper.getReadableDatabase();


        String [] projection = {
                QuestionsContract.QuestionEntry._ID,
                        QuestionsContract.QuestionEntry.QUESTION,
                        QuestionsContract.QuestionEntry.ANSWER1,
                        QuestionsContract.QuestionEntry.ANSWER2,
                        QuestionsContract.QuestionEntry.ANSWER3
        };


        TextView learnView = (TextView) findViewById(R.id.learnTextView);

        Cursor cursor = db.query(QuestionsContract.QuestionEntry.TABLE_NAME,projection,null, null, null, null, null);


        learnView.setText("num rows: " + String.valueOf(cursor.getCount()));



        //while (cursor.moveToNext()){

        //}

        cursor.close();
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
}


/* Playing a video saved in the raw file
VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.big_buck_bunny);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
 */
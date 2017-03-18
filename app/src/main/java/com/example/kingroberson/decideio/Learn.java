package com.example.kingroberson.decideio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class Learn extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


//        Question question = new Question("qTest", "a1test", "a2test", "a3test");
//        question.save();

        List<Question> questions = Question.listAll(Question.class);

        TextView learnView = (TextView) findViewById(R.id.learnTextView);

        String question_stuff = "";
        for (Question question : questions) {
            question_stuff += "\n\n\n\n";
            question_stuff += question.question;
            question_stuff += "\n";
            question_stuff += question.answer1;
            question_stuff += "\n";
            question_stuff += question.answer2;
            question_stuff += "\n";
            question_stuff += question.answer3;
            question_stuff += "\n";
        }

        learnView.setText("All the questions squished together: " + question_stuff);




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
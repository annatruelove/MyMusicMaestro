package com.example.joycezhong.game;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input;
    ImageView image;
    int currentQuestion;
    int score;
    Button restart;
    Question[] questions = new Question[7];


    // GameClass game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.answerEditText);
        image = (ImageView) findViewById(R.id.imageView);
        restart = (Button) findViewById(R.id.restart);
        String answer = input.getText().toString();
        currentQuestion = 0;
        score = 0;

        //String answer, String question, String soundFile

        questions[0] = new Question("C", "What is the correct note?", R.raw.c4, R.drawable.c4);
        questions[1] = new Question("A", "What is the correct note?", R.raw.a4, R.drawable.a4);
        questions[2] = new Question("E", "What is the correct note?", R.raw.e4, R.drawable.e4);
        questions[3] = new Question("G", "What is the correct note?", R.raw.g4, R.drawable.g4);
        questions[4] = new Question("B", "What is the correct note?", R.raw.b4, R.drawable.b4);
        questions[5] = new Question("D", "What is the correct note?", R.raw.d4, R.drawable.d4);
        questions[6] = new Question("F", "What is the correct note?", R.raw.f4, R.drawable.f4);

    }

    public void checkAnswer(View view) {
        if (input.getText().toString().toUpperCase().equals(questions[currentQuestion]._answer)) {
            score += 1;
            if (currentQuestion < questions.length) {
                currentQuestion += 1;

            }
            Toast.makeText(getApplicationContext(), "You got it right!!!", Toast.LENGTH_LONG).show();
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.clapping);
            mediaPlayer.start();

        } else {
            Toast.makeText(getApplicationContext(), "You are wrong", Toast.LENGTH_LONG).show();
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aw);
            mediaPlayer.start();

            score = 0;

        }
        Toast.makeText(this, String.valueOf(score), Toast.LENGTH_LONG).show();

        if (score == 7) {
            Toast.makeText(getApplicationContext(), "You are the maestro!", Toast.LENGTH_LONG).show();
            restart.setVisibility(View.VISIBLE);
        }
        input.setText("");
    }

    public void click(View view) {
        score = 0;
        currentQuestion = 0;
        playSound(view);
        restart.setVisibility(View.INVISIBLE);

    }

    public void playSound(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), questions[currentQuestion]._soundFile);
        image.setImageResource(questions[currentQuestion]._pic);
        mediaPlayer.start();
    }


}

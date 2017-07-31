package com.harpreetdev.pianodemoapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    String note;
    EditText etNotes;
    Button buttonPlay,buttonStop;
    private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNotes = (EditText) findViewById(R.id.edittext_music_notes);
        buttonPlay = (Button) findViewById(R.id.button_play);
        buttonStop = (Button) findViewById(R.id.button_stop);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if(mediaPlayer != null)
                {
                    mediaPlayer.release();
                    counter = 0;
                }
                play();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();

            }
        });

    }
       private void playSound() {
            String notes[] = etNotes.getText().toString().split(" ");
            String note=notes[counter];
            setMediaPlayer( note );
            if(mediaPlayer != null)
            {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                    counter++;
                    play();

                }
             });
            }
        }


    private void play()
        {
            String notes[] = etNotes.getText().toString().split(" ");

            if(counter<notes.length)
            {
                playSound();
            }

         }

    private void setMediaPlayer(String note) {
        this.note = note;
        switch (note){
            case "A1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.a1);
                break;
            case "A1s":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.a1s);
                break;
            case "B1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.b1);
                break;
            case "C1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.c1);
                break;
            case "C1s":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.c1s);
                break;
            case "C2":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.c2);
                break;
            case "D1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.d1);
                break;
            case "D1s":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.d1s);
                break;
            case "E1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.e1);
                break;
            case "F1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.f1);
                break;
            case "F1s":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.f1s);
                break;
            case "G1":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.g1);
                break;
            case "G1s":
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.g1s);
                break;
            case ".":
                try {
                        mediaPlayer.release();
                        Thread.sleep(50);
                        counter++;
                        play();
                    }
                    catch (InterruptedException e)
                    {
                         e.printStackTrace();
                    }
                break;
            default:
                try
                    {   mediaPlayer=null;
                        Toast.makeText(getApplicationContext(),"Illegal Note entered at "+(counter+1)+" position",Toast.LENGTH_SHORT).show();
                        counter=0;
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                break;

        }

    }
}

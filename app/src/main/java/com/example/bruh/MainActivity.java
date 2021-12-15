package com.example.bruh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button m1=findViewById(R.id.m1);
        final Button m2=findViewById(R.id.m2);
        final Button m3=findViewById(R.id.m3);
        final Button m4=findViewById(R.id.m4);
        final Button m5=findViewById(R.id.m5);
        final Button m6=findViewById(R.id.m6);
        final Button m7=findViewById(R.id.m7);
        final Button m8=findViewById(R.id.m8);
        final Button m9=findViewById(R.id.m9);
        final Button m10=findViewById(R.id.m10);
        final Button m11=findViewById(R.id.m11);
        final Button m12=findViewById(R.id.m12);
        final Button m13=findViewById(R.id.m13);
        final Button m14=findViewById(R.id.m14);
        final Button m15=findViewById(R.id.m15);
        final Button next=findViewById(R.id.nextPage);
        final Button sleep=findViewById(R.id.sleep);
        final Button stop=findViewById(R.id.stop);
        final Boolean[] sl = {false};
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sverchki);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.daladna);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.chto);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.povorot);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.zv);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.badums);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.kuv);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.strahno);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.paren);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.krisa);
        final MediaPlayer mp11 = MediaPlayer.create(this, R.raw.tututu);
        final MediaPlayer mp12 = MediaPlayer.create(this, R.raw.polnomochia);
        final MediaPlayer mp13 = MediaPlayer.create(this, R.raw.kva);
        final MediaPlayer mp14 = MediaPlayer.create(this, R.raw.eralash);
        final MediaPlayer mp15 = MediaPlayer.create(this, R.raw.haha);
        final MediaPlayer[] mp = {mp1};

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sl[0]){
                    sleep.setText("Не спать");
                    sl[0] = false;
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }
                else{
                    sleep.setText("Спать");
                    sl[0]=true;
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }
            }
        });


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                    mp[0] = mp1;
                    mp1.start();

            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp2;
                mp2.start();
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp3;
                mp3.start();
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp4;
                mp4.start();
            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp5;
                mp5.start();
            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp6;
                mp6.start();
            }
        });
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp7;
                mp7.start();
            }
        });
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp8;
                mp8.start();
            }
        });
        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp9;
                mp9.start();
            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp10;
                mp10.start();
            }
        });
        m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp11;
                mp11.start();
            }
        });
        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp12;
                mp12.start();
            }
        });
        m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp13;
                mp13.start();
            }
        });
        m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp14;
                mp14.start();
            }
        });
        m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
                mp[0] =mp15;
                mp15.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp[0].pause();
                mp[0].seekTo(0);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_two);
            }
        });

                    }
                    public void check(MediaPlayer mp1, MediaPlayer mp2,MediaPlayer mp3,MediaPlayer mp4,MediaPlayer mp5,MediaPlayer mp6,MediaPlayer mp7,MediaPlayer mp8,MediaPlayer mp9,MediaPlayer mp10,MediaPlayer mp11,MediaPlayer mp12,MediaPlayer mp13,MediaPlayer mp14,MediaPlayer mp15){

                            if (mp1.isPlaying()){
                                mp1.pause();
                                mp1.seekTo(0);
                            }
                            if (mp2.isPlaying()){
                                mp2.pause();
                                mp2.seekTo(0);
                            }
                            if (mp3.isPlaying()){
                                mp3.pause();
                                mp3.seekTo(0);
                            }
                            if (mp4.isPlaying()){
                                mp4.pause();
                                mp5.seekTo(0);
                            }
                            if (mp5.isPlaying()){
                                mp5.pause();
                                mp5.seekTo(0);
                            }
                            if (mp6.isPlaying()){
                                mp6.pause();
                                mp6.seekTo(0);
                            }
                            if (mp7.isPlaying()){
                                mp7.pause();
                                mp7.seekTo(0);
                            }
                            if (mp8.isPlaying()){
                                mp8.pause();
                                mp9.seekTo(0);
                            }
                            if (mp9.isPlaying()){
                                mp9.pause();
                                mp9.seekTo(0);
                            }
                            if (mp10.isPlaying()){
                                mp10.pause();
                                mp10.seekTo(0);
                            }
                            if (mp11.isPlaying()){
                                mp11.pause();
                                mp11.seekTo(0);
                            }
                            if (mp12.isPlaying()){
                                mp12.pause();
                                mp12.seekTo(0);
                            }
                            if (mp13.isPlaying()){
                                mp13.pause();
                                mp13.seekTo(0);
                            }
                            if (mp14.isPlaying()){
                                mp14.pause();
                                mp14.seekTo(0);
                            }
                            if (mp15.isPlaying()){
                                mp15.pause();
                                mp15.seekTo(0);
                            }


    }
}







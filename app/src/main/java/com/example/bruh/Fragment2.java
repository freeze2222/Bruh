package com.example.bruh;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    Button m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,stopButton;
    @Override
    @SuppressLint("CutPasteId")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView= inflater.inflate(R.layout.fragment_2, container, false);
        m1=rootView.findViewById(R.id.m1);
        m2=rootView.findViewById(R.id.m2);
        m3=rootView.findViewById(R.id.m3);
        m4=rootView.findViewById(R.id.m4);
        m5=rootView.findViewById(R.id.m5);
        m6=rootView.findViewById(R.id.m6);
        m7=rootView.findViewById(R.id.m7);
        m8=rootView.findViewById(R.id.m8);
        m9=rootView.findViewById(R.id.m9);
        m10=rootView.findViewById(R.id.m10);
        m11=rootView.findViewById(R.id.m11);
        m12=rootView.findViewById(R.id.m12);
        m13=rootView.findViewById(R.id.m13);
        m14=rootView.findViewById(R.id.m14);
        m15=rootView.findViewById(R.id.m15);
        stopButton=rootView.findViewById(R.id.stop);
        final MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.sverchki);
        final MediaPlayer mp2 = MediaPlayer.create(getActivity(), R.raw.daladna);
        final MediaPlayer mp6 = MediaPlayer.create(getActivity(), R.raw.chto);
        final MediaPlayer mp15 = MediaPlayer.create(getActivity(), R.raw.povorot);
        final MediaPlayer mp8 = MediaPlayer.create(getActivity(), R.raw.zv);
        final MediaPlayer mp3 = MediaPlayer.create(getActivity(), R.raw.badums);
        final MediaPlayer mp11 = MediaPlayer.create(getActivity(), R.raw.kuv);
        final MediaPlayer mp13 = MediaPlayer.create(getActivity(), R.raw.strahno);
        final MediaPlayer mp10 = MediaPlayer.create(getActivity(), R.raw.paren);
        final MediaPlayer mp12 = MediaPlayer.create(getActivity(), R.raw.krisa);
        final MediaPlayer mp9 = MediaPlayer.create(getActivity(), R.raw.tututu);
        final MediaPlayer mp7 = MediaPlayer.create(getActivity(), R.raw.polnomochia);
        final MediaPlayer mp14 = MediaPlayer.create(getActivity(), R.raw.kva);
        final MediaPlayer mp4 = MediaPlayer.create(getActivity(), R.raw.eralash);
        final MediaPlayer mp5 = MediaPlayer.create(getActivity(), R.raw.haha);
        final MediaPlayer[] mp = {mp1};



        stopButton.setOnClickListener(view -> {
            mp[0].pause();
            mp[0].seekTo(0);
        });
        m1.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] = mp1;
            mp1.start();

        });
        m2.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp2;
            mp2.start();
        });
        m3.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp3;
            mp3.start();
        });
        m4.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp4;
            mp4.start();
        });
        m5.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp5;
            mp5.start();
        });
        m6.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp6;
            mp6.start();
        });
        m7.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp7;
            mp7.start();
        });
        m8.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp8;
            mp8.start();
        });
        m9.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp9;
            mp9.start();
        });
        m10.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp10;
            mp10.start();
        });
        m11.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp11;
            mp11.start();
        });
        m12.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp12;
            mp12.start();
        });
        m13.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp13;
            mp13.start();
        });
        m14.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp14;
            mp14.start();
        });
        m15.setOnClickListener(v -> {
            check(mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15);
            mp[0] =mp15;
            mp15.start();
        });
        return rootView;
    }
    public void check(MediaPlayer mp1, MediaPlayer mp2,MediaPlayer mp3,MediaPlayer mp4,
                      MediaPlayer mp5,MediaPlayer mp6,MediaPlayer mp7,MediaPlayer mp8,
                      MediaPlayer mp9,MediaPlayer mp10,MediaPlayer mp11,MediaPlayer mp12,
                      MediaPlayer mp13,MediaPlayer mp14,MediaPlayer mp15){

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
            mp4.seekTo(0);
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
            mp8.seekTo(0);
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
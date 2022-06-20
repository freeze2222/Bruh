package com.example.bruh;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    Button m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,stopButton;
    MediaPlayer mediaPlayer=new MediaPlayer();
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
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        stopButton.setOnClickListener(view -> {
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        });
        m1.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.sverchki);
            setTrack(url);
        });
        m2.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.daladna);
            setTrack(url);
        });
        m3.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.badums);
            setTrack(url);
        });
        m4.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.eralash);
            setTrack(url);
        });
        m5.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.haha);
            setTrack(url);
        });
        m6.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chto);
            setTrack(url);
        });
        m7.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.polnomochia);
            setTrack(url);
        });
        m8.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.zv);
            setTrack(url);
        });
        m9.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.tututu);
            setTrack(url);
        });
        m10.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.paren);
            setTrack(url);
        });
        m11.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.kuv);
            setTrack(url);
        });
        m12.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.krisa);
            setTrack(url);
        });
        m13.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.strahno);
            setTrack(url);
        });
        m14.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.kva);
            setTrack(url);
        });
        m15.setOnClickListener(v -> {
            Uri url = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.povorot);
            setTrack(url);
        });
        return rootView;
    }
    protected void setTrack(Uri url){
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                setTrack(url);
            } else {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(getContext(), url);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.prepareAsync();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
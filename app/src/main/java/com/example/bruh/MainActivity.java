package com.example.bruh;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    final Boolean[] sl = {false};
    String [] names={"Не задано","Не задано","Не задано","Не задано","Не задано","Не задано","Не задано","Не задано","Не задано","Не задано"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button sleep=findViewById(R.id.sleep);
        Button stop=findViewById(R.id.stop);
        MediaPlayer mediaPlayer=new MediaPlayer();
        Button[] buttons= {
                findViewById(R.id.b1),
                findViewById(R.id.b2),
                findViewById(R.id.b3),
                findViewById(R.id.b4),
                findViewById(R.id.b5),
                findViewById(R.id.b6),
                findViewById(R.id.b7),
                findViewById(R.id.b8),
                findViewById(R.id.b9),
                findViewById(R.id.b10)
        };
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer player) {
                player.start();
            }
        });
        for (int i=0;i< buttons.length;i++){
            SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            int res = saved_values.getInt("b"+ i, -1);
            if (res!=-1){
                buttons[i].setText(getResources().getResourceEntryName(res));
                names[i]=getResources().getResourceEntryName(res);
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.reset();
                        try {
                            AssetFileDescriptor afd = getResources().openRawResourceFd(res);
                            if (afd != null) {
                                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                afd.close();
                                mediaPlayer.prepareAsync();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            else {
                try {
                    Uri uri=Uri.parse(saved_values.getString("mpb"+i,"null"));
                    Log.e("DEB", String.valueOf(uri));
                    if (uri!=null) {
                        buttons[i].setText(getFileName(getApplicationContext(),uri));
                        names[i]=getFileName(getApplicationContext(),uri);
                        buttons[i].setOnClickListener(view -> {
                            mediaPlayer.reset();
                            try {
                                    mediaPlayer.setDataSource(getApplicationContext(),uri);
                                    mediaPlayer.prepareAsync();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }


        }

        Button floatingActionButton=findViewById(R.id.edit);
        sleep.setOnClickListener(view -> {
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
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ListActivity.class);
                try {
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                    intent.putExtra("nameTable",names);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


    }
    @SuppressLint("Range")
    public static String getFileName(Context context, Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

}







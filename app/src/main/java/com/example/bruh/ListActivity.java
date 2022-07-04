package com.example.bruh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bruh.adapters.ListAdapter;

import java.util.Arrays;

public class ListActivity extends AppCompatActivity {
    private ActivityResultLauncher<String> mGetContent;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle extras = getIntent().getExtras();
        String[] nameTable = extras.getStringArray("nameTable");
        Log.e("nametable", Arrays.toString(nameTable));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ImageView close=findViewById(R.id.close);
        ImageView upload=findViewById(R.id.upload);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        ListAdapter adapter=new ListAdapter(getBaseContext(),nameTable);
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        close.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        });
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        LayoutInflater inflater = (LayoutInflater)
                                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.popup_choose_window, null);

                        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

                        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
                        popupWindow.setAnimationStyle(R.style.popup_window_animation);
                        popupWindow.showAtLocation(findViewById(R.id.cl), Gravity.CENTER, 0, 0);

                        popupView.setOnTouchListener((View v, @SuppressLint("ClickableViewAccessibility") MotionEvent event) -> {
                            popupWindow.dismiss();
                            return true;
                        });
                         
                        Button[] buttons = new Button[]{
                                popupView.findViewById(R.id.bp1),
                                popupView.findViewById(R.id.bp2),
                                popupView.findViewById(R.id.bp3),
                                popupView.findViewById(R.id.bp4),
                                popupView.findViewById(R.id.bp5),
                                popupView.findViewById(R.id.bp6),
                                popupView.findViewById(R.id.bp7),
                                popupView.findViewById(R.id.bp8),
                                popupView.findViewById(R.id.bp9),
                                popupView.findViewById(R.id.bp10)
                        };
                        for (int i = 0; i < 10; i++) {
                            int finalI = i;
                            buttons[i].setOnClickListener(view1 -> {
                                SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editor = saved_values.edit();
                                editor.putInt("b"+ finalI, -1);
                                editor.putString("mpb" + finalI, String.valueOf(uri));
                                editor.apply();
                                popupWindow.dismiss();
                            });
                            SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            int res = saved_values.getInt("b" + i, -1);
                            if (res != -1) {
                                buttons[i].setText(nameTable[i]);
                            }
                        }
                    }
                });

        upload.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("audio/mpeg");
            mGetContent.launch("audio/mp3");

        });
    }
    @Override
    public void onBackPressed() {
        //nothing
    }

}
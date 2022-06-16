package com.example.bruh;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity{
    Fragment current = new Fragment2();
    final int[] btnClicks = {0};
    final Boolean[] sl = {false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next=findViewById(R.id.nextPage);
        Button sleep=findViewById(R.id.sleep);
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
        next.setOnClickListener(view -> changeFragment(new Fragment2()));
    }
    private void changeFragment (Fragment newFragment){
        Animation fadeIn = new AlphaAnimation(1.0F, 0.0F);
        fadeIn.setDuration(500);

        View view = findViewById(R.id.fragmentContainerView);
        if (btnClicks[0] == 0) {
            view.startAnimation(fadeIn);
            Animation fadeout = new AlphaAnimation(0.0F, 1.0F);
            fadeout.setDuration(500);
            btnClicks[0] += 1;
            view.postDelayed(() -> {
                view.startAnimation(fadeout);
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(current)
                        .show(newFragment)
                        .commit();
                current = newFragment;

            }, 500);
            view.postDelayed(() -> btnClicks[0] -= 1, 750);
        }

    }
}







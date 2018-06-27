package com.app.daggarmvvmnotes.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import com.app.daggarmvvmnotes.R;

public class SplashActivity extends BaseActivity {
    private TextView logoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoText = findViewById(R.id.logoText);
        goToNextActivity();
    }

    private void goToNextActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logoText.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        startActivity(new Intent(SplashActivity.this,CreateNoteActivity.class));
                        finish();
                    }
                });
            }
        },2000);
    }
}

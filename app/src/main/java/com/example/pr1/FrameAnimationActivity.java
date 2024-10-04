package com.example.pr1;

import android.os.Bundle;

import android.graphics.drawable.AnimationDrawable;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class FrameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable frameAnimation;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.frame_animation);

        frameAnimation = (AnimationDrawable) imageView.getBackground();

        // Кнопка для паузы
        Button buttonPause = findViewById(R.id.button_pause);
        buttonPause.setOnClickListener(v -> {
            if (isPaused) {
                resumeAnimation();
            } else {
                pauseAnimation();
            }
        });

        // Кнопка для перезапуска
        Button buttonRestart = findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(v -> restartAnimation());

        // Начинаем анимацию
        startAnimation();
    }

    private void startAnimation() {
        frameAnimation.start();
        isPaused = false;
    }

    private void pauseAnimation() {
        // Если анимация уже идет, остановить ее
        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
            isPaused = true;
        }
    }

    private void resumeAnimation() {
        // Возобновить анимацию с текущего кадра
        if (!frameAnimation.isRunning()) {
            frameAnimation.start();
            isPaused = false;
        }
    }

    private void restartAnimation() {
        frameAnimation.stop();
        frameAnimation.start();
        isPaused = false;
    }
}
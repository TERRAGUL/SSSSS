package com.example.pr1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate: Activity создана");

        Animation buttonAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Button buttonFrame = findViewById(R.id.button_frame_animation);
        Button buttonTween = findViewById(R.id.button_tween_animation);

        if (buttonFrame != null && buttonTween != null) {
            Log.d("MainActivity", "Кнопки найдены в макете");

            buttonFrame.startAnimation(buttonAnimation);
            buttonTween.startAnimation(buttonAnimation);

            buttonFrame.setOnClickListener(v -> {
                Log.d("MainActivity", "Кнопка Бегит нажата");
                Intent intent = new Intent(MainActivity.this, FrameAnimationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });

            buttonTween.setOnClickListener(v -> {
                Log.d("MainActivity", "Кнопка Слепой нажата");
                Intent intent = new Intent(MainActivity.this, TweenAnimationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            });
        } else {
            Log.e("MainActivity", "кнопки не найдены");
        }
    }

}
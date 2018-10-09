package com.example.alien.course05task06;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mImageView.setOnClickListener(this::startAnimation);
    }

    @Override
    protected void onPause() {
        mImageView.setOnClickListener(null);
        super.onPause();
    }

    private void startAnimation(View view) {
        Drawable drawable = mImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}

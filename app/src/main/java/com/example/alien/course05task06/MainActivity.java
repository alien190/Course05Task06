package com.example.alien.course05task06;

import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ImageView mImageViewEyes;
    private AnimatedVectorDrawableCompat mEyesAnimation;
    private AnimatedVectorDrawableCompat mHeadAndHandsAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEyesAnimation = AnimatedVectorDrawableCompat.create(this, R.drawable.animated_logo_eyes);
        mHeadAndHandsAnimation = AnimatedVectorDrawableCompat.create(this, R.drawable.animated_logo);
        mImageView = findViewById(R.id.image);
        mImageView.setImageDrawable(mHeadAndHandsAnimation);
        mImageViewEyes = findViewById(R.id.image_eyes);
        mImageViewEyes.setImageDrawable(mEyesAnimation);
        mHeadAndHandsAnimation.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
            @Override
            public void onAnimationEnd(Drawable drawable) {
                mEyesAnimation.start();
                super.onAnimationEnd(drawable);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mImageView.setOnClickListener(this::startAnimation);
        mImageViewEyes.setOnClickListener(this::startAnimation);
    }

    @Override
    protected void onPause() {
        mImageView.setOnClickListener(null);
        mImageViewEyes.setOnClickListener(null);
        super.onPause();
    }

    private void startAnimation(View view) {
        mHeadAndHandsAnimation.start();
    }


}

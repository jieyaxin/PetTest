package com.example.pettest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.example.pettest.view.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private PathView pathview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        pathview.getPathAnimator()
                .delay(10000)
                .duration(20000)
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    }
                }) .interpolator(new AccelerateDecelerateInterpolator())
                .start();
    }

    private void initView() {
        pathview = (PathView) findViewById(R.id.pathview);
    }
}

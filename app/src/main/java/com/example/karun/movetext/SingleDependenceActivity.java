package com.example.karun.movetext;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.hanks.htextview.scale.ScaleTextView;


public class SingleDependenceActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private String[] texts = {
            "This IS Body",
            "You are So Sorry",
            "Can you work on School",
            "What do you want?",
            "Manih is Good Boy"
    };
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_dependence);
        frameLayout = (FrameLayout) findViewById(R.id.container);
        final ScaleTextView view = new ScaleTextView(this);
        view.setText("Using a Library Project means that my overall project will have two manifests");
        view.setTextSize(getResources().getDimension(R.dimen.textsize));
        frameLayout.addView(view);


        new CountDownTimer(90000, 2000) {

            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to edittext

                Log.d("TAGS","seconds remaining: " + millisUntilFinished / 1000);

                index++;
                if (index >= texts.length) {
                    index = 0;
                }
                view.animateText(texts[index]);
            }

            public void onFinish() {
                Log.d("TAGS","done" );


            }

        }.start();

    }
}

package com.example.verticalseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    CustomVerticalSeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.vertical_seekbar);

        seekBar.setOnSeekBarChangeListener(new CustomVerticalSeekBar.OnVerticalSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CustomVerticalSeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(CustomVerticalSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(CustomVerticalSeekBar seekBar, float volume) {
                Log.d("TAG", "onStopTrackingTouch: change value"+volume);
            }
        });
    }
}
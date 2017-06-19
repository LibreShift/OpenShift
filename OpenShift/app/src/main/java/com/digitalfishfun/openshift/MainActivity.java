package com.digitalfishfun.openshift;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBarListener listener = new SeekBarListener();

        final SeekBar RedBar=(SeekBar) findViewById(R.id.RedBar);
        RedBar.setOnSeekBarChangeListener(listener);

        final SeekBar GreenBar=(SeekBar) findViewById(R.id.GreenBar);
        GreenBar.setOnSeekBarChangeListener(listener);

        final SeekBar BlueBar=(SeekBar) findViewById(R.id.BlueBar);
        BlueBar.setOnSeekBarChangeListener(listener);
    }
}

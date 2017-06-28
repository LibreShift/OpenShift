package com.digitalfishfun.openshift;

import android.app.Activity;
import android.widget.SeekBar;

/**
 * Created by joonatoona on 6/19/17.
 */

public class SeekBarListener implements SeekBar.OnSeekBarChangeListener {

    public Helpers helper = new Helpers();

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Activity activity = (Activity) seekBar.getContext();

        SeekBar redBar = activity.findViewById(R.id.RedBar);
        float red = (redBar.getProgress()+1);
        red = red/100;

        SeekBar greenBar = activity.findViewById(R.id.GreenBar);
        float green = (greenBar.getProgress()+1);
        green = green/100;

        SeekBar blueBar = activity.findViewById(R.id.BlueBar);
        float blue = (blueBar.getProgress()+1);
        blue = blue/100;

        helper.sh(String.format("killall echo; echo 1015 i32 1 f %f f 0 f 0 f 0 f 0 f %f f 0 f 0 f 0 f 0 f %f f 0 f 0 f 0 f 0 f 1 > %s &", red, green, blue, activity.getCacheDir()+"/pipe"));
    }
}

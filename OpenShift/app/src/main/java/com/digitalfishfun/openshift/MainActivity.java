package com.digitalfishfun.openshift;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

        File f = new File(getFilesDir()+"/listener.sh");
        if (!f.exists()) try {
            InputStream is = getAssets().open("listener.sh");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File pipe = new File(getCacheDir()+"/pipe");
        if (!pipe.exists()) {
            new Helpers().sh("mkfifo "+getCacheDir()+"/pipe");
            new Helpers().sudo(String.format("sh %s %s &", getFilesDir()+"/listener.sh", getCacheDir()+"/pipe"));
        }
    }

    public void killDemon(View v) {
        new Helpers().sh("echo quit > "+getCacheDir()+"/pipe");
        this.finish();
        System.exit(0);
    }
}

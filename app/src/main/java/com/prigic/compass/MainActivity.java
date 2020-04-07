package com.prigic.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView internal, framework;
    private float currentDegree = 0.f;
    private Compass compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        internal = (ImageView) findViewById(R.id.internal);
        framework = (ImageView) findViewById(R.id.framework);
        compass = new Compass(this, currentDegree, internal, framework);
    }


    @Override
    protected void onResume() {
        super.onResume();
        compass.getSensorManager().registerListener(compass, compass.getSensorManager().getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        compass.getSensorManager().unregisterListener(compass);
    }
}

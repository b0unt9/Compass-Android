package com.prigic.compass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Compass implements SensorEventListener {

    private Context context;
    private ImageView internal, framework;
    private SensorManager sensorManager;
    private float currentDegree = 0.f;

    public SensorManager getSensorManager() {
        return sensorManager;
    }

    public Compass(Context context, float currentDegree, final ImageView internal, final ImageView framework) {
        this.context = context;
        this.sensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        this.currentDegree = currentDegree;
        this.internal = internal;
        this.framework = framework;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float degree = Math.round(sensorEvent.values[0]);
        RotateAnimation rotateAnimation = new RotateAnimation(currentDegree, degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(210);
        rotateAnimation.setFillAfter(true);
        internal.startAnimation(rotateAnimation);
        currentDegree = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}

package com.example.tinku.gpsleep;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SensorManager senMan;
    private Sensor lightSens;
    private SensorEventListener lightChangeList;
    private TextView textView;
    //float lightMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView); //check
        senMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSens = senMan.getDefaultSensor(Sensor.TYPE_LIGHT);
        //lightMax = lightSens.getMaximumRange();
        lightChangeList = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                    float senVal = event.values[0];
                    textView.setText(""+senVal);
                    if(senVal < 10){
                        textView.setText("Dark enough to sleep");
                    }
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    protected void onPause(){
        super.onPause();
        senMan.unregisterListener(lightChangeList);
    }

    protected void onResume(){
    super.onResume();
    senMan.registerListener(lightChangeList,lightSens,SensorManager.SENSOR_DELAY_NORMAL);
    }
}

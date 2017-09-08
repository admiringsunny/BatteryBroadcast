package com.sunny.practice.batterybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt_battery;
    private MyBroadcastRec myBroadcastRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize text and progress_bar
        txt_battery = (TextView) findViewById(R.id.txt_battery);

        // create object reference to MyBroadcastRec
        myBroadcastRec = new MyBroadcastRec();

        // intent for battery
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(myBroadcastRec, intentFilter);
    }

    public class MyBroadcastRec extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            txt_battery.setText("Battery Level is :" + level + "%");
        }
    }
}


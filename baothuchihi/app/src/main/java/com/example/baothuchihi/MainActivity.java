package com.example.baothuchihi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.ListResourceBundle;

public class MainActivity extends AppCompatActivity {
    Button btnhengio,btnstop;
    TextView txthienthi;
    TimePicker Timepicker;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnhengio = (Button) findViewById(R.id.DGio);
        btnstop = (Button) findViewById(R.id.stop);
        txthienthi = (TextView) findViewById(R.id.textView);
        Timepicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();//lay gio hien tai
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);//cho phep truy cap he thong thong bao cua may
        Intent  intent = new Intent(MainActivity.this,Peoplenhan.class);
        btnhengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,Timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,Timepicker.getCurrentMinute());
                int gio = Timepicker.getCurrentHour();
                int phut = Timepicker.getCurrentMinute();
                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);
                pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                txthienthi.setText("Gio ban dat la" + string_gio + ":" + string_phut);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txthienthi.setText("Stop");
                pendingIntent.cancel();
            }
        });
    }

}
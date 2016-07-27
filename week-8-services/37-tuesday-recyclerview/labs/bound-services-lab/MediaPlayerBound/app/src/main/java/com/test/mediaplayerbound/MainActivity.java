package com.test.mediaplayerbound;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Boolean isBound=false;
    CustomBoundService myService;
    Button play;
    Button pause;
    Button stop;

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            CustomBoundService.myCustomBinder binder = (CustomBoundService.myCustomBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.play_button);
        pause = (Button)findViewById(R.id.pause_button);
        stop = (Button)findViewById(R.id.stop_button);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (isBound){
                   myService.play();
               }else{
                   Toast.makeText(MainActivity.this,"not playing",Toast.LENGTH_SHORT).show();
               }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.stop();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              myService.pause();
            }
        });







    }
    protected void onStart() {
        super.onStart();
        // Bind to LocalService
        Intent intent = new Intent(this, CustomBoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (isBound) {
            unbindService(myConnection);
            isBound = false;
        }
    }
}

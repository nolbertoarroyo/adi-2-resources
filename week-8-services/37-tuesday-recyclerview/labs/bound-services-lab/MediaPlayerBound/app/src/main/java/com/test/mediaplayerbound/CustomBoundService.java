package com.test.mediaplayerbound;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by nolbertoarroyo on 7/26/16.
 */
public class CustomBoundService extends Service {
    MediaPlayer mediaPlayer;
    Boolean isPrepared = false;
    String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";

    private final IBinder myBinder = new myCustomBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Nullable
    @Override
    public IBinder onBind(final Intent intent) {
        return myBinder;
    }

    public class myCustomBinder extends Binder {
        CustomBoundService getService() {
            return CustomBoundService.this;
        }
    }

    public void play() {
        //created musicRunnable
        Runnable musicRunnable = new Runnable() {
            @Override
            public void run() {

                if (!isPrepared) {
                    try {
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.setDataSource(url);

                        mediaPlayer.prepareAsync();
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mediaPlayer.start();
                                isPrepared = true;
                            }
                        });
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                stopSelf();
                            }
                        });

                    } catch (Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(CustomBoundService.this, "could not play file", Toast.LENGTH_SHORT).show();
                        stopSelf();
                    }
                }
            }

        };

        new Thread(musicRunnable).start();

    }
    public void stop(){
        mediaPlayer.stop();
        mediaPlayer.release();
        isPrepared = false;

    }
    public void pause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}


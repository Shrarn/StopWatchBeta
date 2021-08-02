package com.example.stopwatchbeta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Timer;
    androidx.appcompat.widget.AppCompatButton Start,Reset;

    private boolean running = false;
    private int sec=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View Stopwatch = findViewById(R.id.StopWatchLayout);
        Stopwatch.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
        Start = findViewById(R.id.start);
        Reset = findViewById(R.id.reset);

        startTimer();
    }

    public void Start(View view) {
        if(!running) {
            running = true;
            Start.setText("Pause");
        }
        else{
            running = false;
            Start.setText("Resume");
        }
    }

    public void Reset(View view) {
        running = false;
        sec = 0 ;
        Timer.setText("00:00:00");
        Start.setText("Start");
    }

    public void startTimer(){
        Timer = findViewById(R.id.Time);
        final Handler handler = new Handler();

        handler.post(new Runnable(){
            @Override
            public void run()
            {
                int hours = sec / 3600;
                int min = (sec % 3600) / 60;
                int second = sec % 60;


                String time = String.format("%02d:%02d:%02d",hours,min,second);
                Timer.setText(time);


                if(running)
                {
                    sec++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}

package yana.geo.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private int seconds = 0;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        runTimer();
    }

    public void StartTimerOnClick(View view) {
        isRunning = true;
    }

    public void PauseTimerOnClick(View view) {
        isRunning = false;
    }

    public void ResetTimerOnClick(View view) {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes,secs);
                textViewTimer.setText(time);
                if (isRunning){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });


    }
}
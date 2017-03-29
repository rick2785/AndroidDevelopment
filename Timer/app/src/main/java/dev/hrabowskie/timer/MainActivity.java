package dev.hrabowskie.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    CheckBox optSingleShot;
    Button btnStart,btnCancel;
    TextView txtCounter;

    Timer timer;
    MyTimerTask myTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optSingleShot = (CheckBox)findViewById(R.id.singleshot);
        btnStart = (Button)findViewById(R.id.start);
        btnCancel = (Button)findViewById(R.id.cancel);
        txtCounter = (TextView)findViewById(R.id.counter);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timer != null)
                    timer.cancel();
                timer = new Timer();
                myTimerTask = new MyTimerTask();

                if(optSingleShot.isChecked()) {
                    timer.schedule(myTimerTask,1000); // 1 sec
                }
                else {
                    timer.schedule(myTimerTask,1000,1000); // delay 1s , repeat 5s
                }
            }


        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timer != null)
                {
                    timer.cancel();
                    timer = null;
                }
            }
        });
    }

    class MyTimerTask extends TimerTask {




        @Override
        public void run() {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
            final String strDate = simpleDateFormat.format(calendar.getTime());

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txtCounter.setText(strDate);
                }
            });
        }
    }
}

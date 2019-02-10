package test.com.helloworld;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private Button b1, b2, b3;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");

        setContentView(R.layout.activity_main);

        init();

        //Doesn't need to implement interface
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "B1: onClick from anonymous inner class called");

                tv2.setText("Changed from Button 1");
                tv2.setTextColor(Color.YELLOW);

                tv1.setBackgroundColor(Color.GREEN);
                tv1.setTextSize(20);
            }
        });

        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b2:
                Log.d(TAG, "B2: onClick: called");

                tv2.setText("Changed from Button 2");
                tv2.setTextColor(Color.RED);

                tv1.setBackgroundColor(Color.YELLOW);
                tv1.setTextSize(22);
                break;
            case R.id.b3:
                Log.d(TAG, "B3: onClick: called");

                tv2.setText("Changed from Button 3");
                tv2.setTextColor(Color.BLUE);

                tv1.setBackgroundColor(Color.RED);
                tv1.setTextSize(24);
                break;
        }
    }

    private void init() {
        Log.d(TAG, "init called");

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }


}

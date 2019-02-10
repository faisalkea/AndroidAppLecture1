package test.com.helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private Button b1, b2, b3, b4, b5, b6, b7;
    private TextView tv1, tv2, tv3;
    private ProgressBar pb;
    private RatingBar rb;

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
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

    }

    /**
     * Initialize view components (Buttons & TextView)
     */
    private void init() {
        Log.d(TAG, "init called");

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        pb = findViewById(R.id.pb);

        rb = findViewById(R.id.rb);
    }


    /**
     * Onclick (override method from OnClickListener) method to switch between buttons
     * @param view
     */
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
            case R.id.b5:
                Log.d(TAG, "B5: onClick: called");

                pb.setVisibility(View.VISIBLE);
                break;
            case R.id.b6:
                Log.d(TAG, "B6: onClick: called");

                pb.setVisibility(View.GONE);
            case R.id.b7:
                Log.d(TAG, "B7: onClick: called");

                String rating = String.valueOf(rb.getRating());
                tv3.setText("Score: " + rating);
                break;
        }
    }

    /**
     * Onclick method defined in xml view
     * @param view
     */
    public void reset(View view) {
        Log.d(TAG, "reset() method called");

        tv1.setText(getString(R.string.tv_1));
        tv1.setBackgroundColor(Color.TRANSPARENT);
        tv1.setTextColor(Color.GRAY);
        tv1.setTextSize(14);

        tv1.setText(getString(R.string.tv_2));
        tv2.setBackgroundColor(Color.TRANSPARENT);
        tv2.setTextColor(Color.GRAY);
        tv2.setTextSize(14);
    }
}

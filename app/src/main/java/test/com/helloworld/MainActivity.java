package test.com.helloworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

    private Button b1, b2, b3, b5, b6, b7, b8;
    private TextView tv1, tv2, tv3, tv4;
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
            }
        });

        tv4.setText(getString(R.string.tv_3) + " " + isOnline());
        tv4.setTextColor(Color.BLACK);
        tv1.setText(getString(R.string.tv_1) + " " + checkNetworkConnection());
        tv1.setTextColor(Color.BLACK);
    }

    /**
     * Initialize view components (Buttons & TextView)
     */
    private void init() {
        Log.d(TAG, "init called");

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);

        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

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
                break;
            case R.id.b3:
                Log.d(TAG, "B3: onClick: called");

                tv2.setText("Changed from Button 3");
                tv2.setTextColor(Color.BLUE);
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
            case R.id.b8:
                Log.d(TAG, "B8: OnClick called");
                Intent intent = new Intent(this, SpinnerActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * Onclick method defined in xml view
     * Doesn't need to be initialized
     * @param view
     */
    public void reset(View view) {
        Log.d(TAG, "reset() method called");

        tv2.setText(getString(R.string.tv_2));
        tv2.setBackgroundColor(Color.TRANSPARENT);
        tv2.setTextColor(Color.GRAY);
        tv2.setTextSize(14);
    }

    private boolean isOnline() {
        Log.d(TAG, "Checking for Internet Connectivity");

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private String checkNetworkConnection() {
        Log.d(TAG, "Checking for Internet Connectivity");
        String result = getString(R.string.no_wifi_or_mobile);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();

        if (activeInfo != null && activeInfo.isConnected()) {
            boolean wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            boolean mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if(wifiConnected) {
                Log.i(TAG, getString(R.string.wifi_connection));
                result =  getString(R.string.wifi_connection);
            } else if (mobileConnected){
                Log.i(TAG, getString(R.string.mobile_connection));
                result = getString(R.string.mobile_connection);
            }
        }

        Log.i(TAG, getString(R.string.no_wifi_or_mobile));
        return result;
    }
}

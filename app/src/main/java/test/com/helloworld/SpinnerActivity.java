package test.com.helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static String TAG = " SpinnerActivity";

    List<String> Workers = new ArrayList<>();
    List<Integer> grades = new ArrayList<>();

    String stud = "";
    String grade = "";

    private static final String STUD = "STUDENT";
    private static final String GRADE = "GRADE";

    private TextView tv1, tv2, tv3, tv4;
    private Spinner s1, s2;

    private boolean userIsInteracting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Log.d(TAG, "OnCreate() called");

        init();

        setupS1();
        setupS2();

        if(savedInstanceState != null){
            Log.d(TAG, "Reading from bundle");

            tv3.setText(savedInstanceState.getString(STUD));
            tv4.setText(savedInstanceState.getString(GRADE));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        Log.d(TAG, "onSaveInstanceState called");

        outState.putString(STUD, "Student: " + stud);
        outState.putString(GRADE, "Grade: " + grade);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy() called");
    }

    private void setupS1() {
        Workers.add("Faisal");
        Workers.add("Yakob");
        Workers.add("Jens");
        Workers.add("Mikkel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Workers);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter);
    }

    private void setupS2() {
        grades.add(12);
        grades.add(10);
        grades.add(7);
        grades.add(4);
        grades.add(2);
        grades.add(0);
        grades.add(-3);

        // Creating adapter for spinner
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grades);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s2.setAdapter(dataAdapter);
    }

    private void init() {
        Log.d(TAG, "Init components");

        tv1 = findViewById(R.id.t1);
        tv2 = findViewById(R.id.t2);
        tv3 = findViewById(R.id.t3);
        tv4 = findViewById(R.id.t4);

        tv3.setTextColor(Color.BLACK);
        tv4.setTextColor(Color.BLACK);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);

        s1.setSelection(0,false);
        s1.setOnItemSelectedListener(this);

        s2.setSelection(0,false);
        s2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        if (!userIsInteracting)
            return;

        switch (parent.getId()){
            case R.id.s1:
                Log.d(TAG, "S1 selected");
                stud = parent.getItemAtPosition(position).toString();

                tv3.setText("Student: " + stud);
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                break;
            case R.id.s2:
                Log.d(TAG, "S2 selected");
                grade = parent.getItemAtPosition(position).toString();

                tv4.setText("Grade: " + grade);
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        userIsInteracting = true;
    }
}

package com.neonsec.lab2sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView greetTv;
    private Button greetButton;
    private EditText nameEt;
    private EditText safeText;
    private String SAFE_TEXT;
    private Button maps;
    private EditText address;
    private Button newActivity;
    private EditText toActivity;
    private TextView fromActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the view
        greetTv = findViewById(R.id.greetTV);
        greetButton = findViewById(R.id.greetButton);
        nameEt = findViewById(R.id.editText);
        safeText = findViewById(R.id.editText2);
        maps = findViewById(R.id.maps);
        address = findViewById(R.id.address);
        newActivity = findViewById(R.id.newActivity);
        toActivity = findViewById(R.id.toActivity);
        fromActivity = findViewById(R.id.fromActivity);

        if(savedInstanceState!= null){
            SAFE_TEXT = savedInstanceState.getString("SAFE_TEXT");
        }

    }

    //Greet function
    public void greetMe(View view) {
        String name;
        name = nameEt.getText().toString();
        greetTv.setText("Hello "+name+"!");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SAFE_TEXT",safeText.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        safeText.setText(SAFE_TEXT);
    }

    public void openMaps(View view) {
        String location;
        location = address.getText().toString();
        String uri = "http://maps.google.co.in/maps?q=" + location;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void openActivity(View view) {

        String sendText;
        sendText = toActivity.getText().toString();

        Intent intent = new Intent(getBaseContext(), OtherActivity.class);
        intent.putExtra("EXTRA_TEXT", sendText);
        startActivityForResult(intent,1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == Activity.RESULT_OK) {
                String returnValue = data.getStringExtra("RETURN_TEXT");
                fromActivity.setText(returnValue);

        }
    }

}

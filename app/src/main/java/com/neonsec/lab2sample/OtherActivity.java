package com.neonsec.lab2sample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    private TextView fromActivity;
    private EditText returnText;
    private String rText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        fromActivity = findViewById(R.id.fromActivity);
        String TextfromActivity = getIntent().getStringExtra("EXTRA_TEXT");
        returnText = findViewById(R.id.editText3);

        fromActivity.setText("HELLO "+ TextfromActivity);



    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        rText = returnText.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("RETURN_TEXT", rText);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}

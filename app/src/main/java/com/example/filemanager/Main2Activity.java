package com.example.filemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String message = "Hello "+intent.getStringExtra(FileAdapter.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);


    }


}

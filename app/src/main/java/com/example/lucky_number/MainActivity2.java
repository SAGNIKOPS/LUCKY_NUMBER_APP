package com.example.lucky_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.button3);
        TextView textView = findViewById(R.id.textView3);

        Intent i = getIntent();
        String value = i.getStringExtra("name");

        int randomNumber = generateRandomNumbers();
        textView.setText(""+randomNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(value,randomNumber);
            }
        });
    }
    public int generateRandomNumbers()
    {
        Random random = new Random();
        int value = random.nextInt(1000);
        return value;
    }

    public void setData(String value,int randomNumber)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,value+" got lucky Guys");
        i.putExtra(Intent.EXTRA_TEXT,randomNumber+" is the lucky Number");

        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}
package com.example.jason.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jason on 2016/7/28.
 */
public class secActivity extends AppCompatActivity {

    Button Button1,Button2,Button3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seclayout);
        Button1=(Button)findViewById(R.id.button4);
        Button1.setText(getIntent().getStringExtra("hello"));


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.putExtra("result","xxxxx");
                setResult(98,i);
                finish();
            }
        });
    }

}

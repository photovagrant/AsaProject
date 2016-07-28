package com.example.jason.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button Button1,Button2,Button3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        Button1=(Button)findViewById(R.id.button);
        Button2=(Button)findViewById(R.id.button2);
        Button3=(Button)findViewById(R.id.button3);


//        textView.setOnClickListener(new OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                textView.setText("123");
//            }
//        });

        Button1.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,secActivity.class);

                i.putExtra("hello","world");

                startActivity(i);
//                finish();

            }
        });

        Button2.setOnClickListener(this);
        Button3.setOnClickListener(btnListener);






    }

    private Button.OnClickListener btnListener= new OnClickListener() {
        @Override
        public void onClick(View view) {

            if(view.getId()==R.id.button2) {
                textView.setText("btm2");
            }
            else if(view.getId()==R.id.button3)
            {
                Intent i=new Intent(MainActivity.this,secActivity.class);
                i.putExtra("hello","world again");
                startActivityForResult(i,0);
//                finish();
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("","=====  "+resultCode);
//        if(requestCode==0)
//        {
//        data.getStringExtra("result");

        if(resultCode==99)
                textView.setText("test");
        else if(resultCode==98)
        {
            finish();
            textView.setText( data.getStringExtra("result") );
        }
//        }

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button2)
            textView.setText("btm22");
        else if(view.getId()==R.id.button3)
            textView.setText("btm33");
    }
}

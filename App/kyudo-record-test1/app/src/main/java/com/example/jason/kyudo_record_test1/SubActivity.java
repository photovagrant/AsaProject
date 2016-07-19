package com.example.jason.kyudo_record_test1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jason on 2016/7/19.
 */
public class SubActivity  extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate ( savedInstanceState, persistentState );
        setContentView(R.layout.sublayout);
        result test=(result)getIntent ().getSerializableExtra ( "tag" );
        Log.e("test",test.getName ());



    }
}

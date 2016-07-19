package com.example.jason.kyudo_record_test1;

import java.io.Serializable;

/**
 * Created by jason on 2016/7/10.
 */
public class result implements Serializable {
    private static final long serialVersionUID = 1234567;
    public result(String name){
     this.name=name;
    }
    public String getName(){
        return name;
    }

String name ;



}

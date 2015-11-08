package com.hufflepuff.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamper {

    public static String getTime() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }
}

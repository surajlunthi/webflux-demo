package com.learnwebflux.webfluxdemo.util;

public class SleepUtil {
    public static void sleep(int sec) {
        try {
            Thread.sleep((sec*1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}

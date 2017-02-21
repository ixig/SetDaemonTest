package com.gopro.threads;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {} /* protect against instantiation */

    public static Singleton getInstance() { return instance; }

}

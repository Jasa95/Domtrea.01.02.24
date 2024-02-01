package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        HTag htag = new HTag(1);
        htag.setTagName("jeg er h1");

        System.out.println(htag);
    }
}
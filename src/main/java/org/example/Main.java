package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");

        HTag hTag = new HTag(1);
        hTag.setTagName("jeg er h1");

       // System.out.println(htag);

        System.out.println(hTag.toHTMLString());

        ArrayList<Tag> hTags = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            HTag h1 = new HTag(i);
            h1.setTagText("jeg er et " + h1.getTagName() + " tag");
            h1.setColor(i*4, i*3, i*5);
            hTags.add(h1);
            for (int j=i; j<=5; j++) {
                Ptag ptag = new Ptag();
                ptag.setTagText("Jeg er et ptag i htag " + hTag.getTagName());
                ptag.setColor(j*1, j*2, j*7);
                hTags.add(ptag);
            }
        }
    System.out.println(hTags);

        for (Tag tag: hTags) {
            //System.out.println(tag.toHTMLString());
            if (tag instanceof Ptag) {
               // System.out.println("jeg er et ptag");
            }
        }

        BodyTag body = new BodyTag();
        body.setChildren(hTags);
        System.out.println(body);
        System.out.println(body.toHTMLString());
        body.toHTMLStringFile("index.html");

        body.rgbToHex(255, 23, 9);
        System.out.println(body.getColor());

    }
}
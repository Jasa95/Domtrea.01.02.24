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
            hTags.add(h1);
            for (int j=i; j<=5; j++) {
                Ptag ptag = new Ptag();
                ptag.setTagText("Jeg er et ptag i htag " + hTag.getTagName());
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
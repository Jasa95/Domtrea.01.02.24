package org.example;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class Tag {
    private String id;
    private String tagName;
    private String tagText;
    private List<Tag> children;
    private String color = ""; //#ff0000 = red

    public Tag() {
        children = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(int red, int green, int blue) {
        String r = Integer.toHexString(red);
        String g = Integer.toHexString(green);
        String b = Integer.toHexString(blue);
        this.setColor("#" + r + g + b);
    }

    public static String rgbToHex(int red, int green, int blue) {
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        String colorString = String.format("#%02x%02x%02x", red, green, blue);

        return colorString;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagText='" + tagText + '\'' + "children=" + this.children.size() +
                '}';
    }

    public String toHTMLStringNoChildren() {
        String s1 = "<" + tagName + ">"; // <h1>
        s1 = s1 + tagText + "<" + tagName + ">"; // <h1>text
        return s1;
    }
    public String toHTMLString() {
        String s1 = "";
        if (this.getColor().length() > 0) {
            s1 = "<" + tagName + " style=" + '"' + "background-color:" + color + '"' + ">";
        } else{
            s1 = "<" + tagName + ">";
        }
        for (Tag tag: children) {
            String child = tag.toHTMLString();
            s1 = s1 + (char) 10 + child;
        }
        s1 = s1 + tagText + "<" + tagName + ">"; // <h1>text
        return s1;
    }

    public String toHTMLStringFile(String fileName) {
        String outputFile = fileName;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(this.toHTMLString());
            writer.close();
        } catch (Exception msg) {
            System.out.println(msg);
        }
        return fileName;
    }

}

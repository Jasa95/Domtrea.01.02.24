package org.example;

public class HTag extends Tag {
    private byte number;

    public HTag(int hNumber) {
        number = (byte) hNumber;
        this.setTagName("h" + hNumber);
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = (byte) number;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "HTag{" +
                "number=" + number +
                '}';
    }
}

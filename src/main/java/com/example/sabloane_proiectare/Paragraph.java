package com.example.sabloane_proiectare;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.textAlignment = strategy;
    }

    @Override
    public void print() {
        if (textAlignment == null) {
            System.out.println("Paragraph: " + text);
        } else {
            textAlignment.render(this, null);
        }
    }

    public String getText() {
        return text;
    }
}

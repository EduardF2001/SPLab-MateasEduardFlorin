package com.example.sabloane_proiectare;

public class AlignLeft implements AlignStrategy {
    private final int lineWidth;

    public AlignLeft(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public void render(Paragraph paragraph, Object context) {
        System.out.println("Left alignment: " + String.format("%-" + lineWidth + "s", paragraph.getText()));
    }
}
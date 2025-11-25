package com.example.sabloane_proiectare;

public class AlignRight implements AlignStrategy {
    private final int lineWidth;

    public AlignRight(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public void render(Paragraph paragraph, Object context) {
        System.out.println("Right alignment: " + String.format("%" + lineWidth + "s", paragraph.getText()));
    }
}

package com.example.sabloane_proiectare;

public class AlignCenter implements AlignStrategy {
    private final int lineWidth;

    public AlignCenter(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public void render(Paragraph paragraph, Object context) {
        String text = paragraph.getText();
        int padding = (lineWidth - text.length()) / 2;
        padding = Math.max(0, padding);

        System.out.println("Center alignment: " + " ".repeat(padding) + text);
    }
}

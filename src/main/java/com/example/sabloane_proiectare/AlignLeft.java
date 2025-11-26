package com.example.sabloane_proiectare;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Object context) {
        System.out.println("<< " + paragraph.getText());
    }
}

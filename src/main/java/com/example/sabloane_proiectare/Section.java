package com.example.sabloane_proiectare;
public class Section extends Element {
    private String title;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
    }
}

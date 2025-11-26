package com.example.sabloane_proiectare;

public class 3TableOfContents implements Element {
    private String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents: " + content);
    }
}

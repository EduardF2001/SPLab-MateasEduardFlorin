package com.example.sabloane_proiectare;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element e : children) {
            e.print();
        }
    }

    @Override
    public void addElement(Element element) {
        children.add(element);
    }

    @Override
    public void removeElement(Element element) {
        children.remove(element);
    }

    @Override
    public Element getElement(int index) {
        return children.get(index);
    }

    public void add(Paragraph paragraph) {
        children.add(paragraph);
    }
}

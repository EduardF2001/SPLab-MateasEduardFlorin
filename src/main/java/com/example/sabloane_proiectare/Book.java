package com.example.sabloane_proiectare;

import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors:");
        for (Author author : authors) {
            author.print();
        }

        System.out.println();
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void removeElement(Element element) {
        elements.remove(element);
    }

    @Override
    public Element getElement(int index) {
        return elements.get(index);
    }
}

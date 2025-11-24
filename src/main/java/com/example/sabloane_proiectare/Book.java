package com.example.sabloane_proiectare;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Element> elements = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors:");
        for (Author author : authors) {
            author.print();
        }

        System.out.println();
        for (Element element : elements) {
            printElementRecursive(element);
        }
    }

    private void printElementRecursive(Element element) {
        element.print();

    }
}

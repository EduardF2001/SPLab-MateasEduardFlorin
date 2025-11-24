package com.example.sabloane_proiectare;

public class Main {
    public static void main(String[] args) {
        Book Carte1 = new Book("Morometii !");
        Author Autor1 = new Author("Marin", "Preda");
        Carte1.addAuthor(Autor1);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        Carte1.addContent(new Paragraph("Multumesc celor care ..."));
        Carte1.addContent(cap1);
        // cap1.print();
        // cap11.print();
        // cap111.print();
        // cap1111.print();

        Carte1.addContent(new Paragraph("Text from subchapter 1.1"));
        Carte1.addContent(new Paragraph("Text from subchapter 1.1.1"));
        Carte1.addContent(new Image("Image subchapter 1.1.1.1"));

        Carte1.print();
    }
}

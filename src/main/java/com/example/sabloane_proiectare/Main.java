//package com.example.sabloane_proiectare;
//
//public class Main {
//    public static void main(String[] args) {
//        Book noapteBuna = new Book("Noapte buna, copii!");
//        Author rpGheo = new Author("Radu Pavel", "Gheo");
//        noapteBuna.addAuthor(rpGheo);
//
//        Section cap1 = new Section("Capitolul 1");
//        cap1.addElement(new Paragraph("Moto capitol"));
//        cap1.addElement(new Paragraph("Multumesc celor care ..."));
//
//        Paragraph alignedP = new Paragraph("Text aligned left");
//        alignedP.setAlignStrategy(new AlignLeft());
//
//        Paragraph alignedRight = new Paragraph("Text aligned right");
//        alignedRight.setAlignStrategy(new AlignRight());
//
//        cap1.addElement(alignedP);
//        cap1.addElement(alignedRight);
//        cap1.addElement(new Image("image1.jpg"));
//        cap1.addElement(new Table("Table 1"));
//
//        noapteBuna.addElement(cap1);
//
//        noapteBuna.print();
//    }
//}

package com.example.sabloane_proiectare;

public interface Element {
    void print();
    default void addElement(Element element) {
        throw new UnsupportedOperationException();
    }
    default void removeElement(Element element) {
        throw new UnsupportedOperationException();
    }
    default Element getElement(int index) {
        throw new UnsupportedOperationException();
    }
}

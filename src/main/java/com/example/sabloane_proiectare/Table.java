package com.example.sabloane_proiectare;
public class Table extends Element {
    private String CevaInformatii;

    public Table(String CevaInformatii) {
        this.CevaInformatii = CevaInformatii;
    }

    @Override
    public void print() {
        System.out.println("Table: " + CevaInformatii);
    }
}

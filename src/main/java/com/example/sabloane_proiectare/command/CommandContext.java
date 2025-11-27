package com.example.sabloane_proiectare.command;

import com.example.sabloane_proiectare.service.BooksService;

public class CommandContext {
    private final BooksService booksService;

    public CommandContext(BooksService booksService) {
        this.booksService = booksService;
    }

    public BooksService booksService() {
        return booksService;
    }
}
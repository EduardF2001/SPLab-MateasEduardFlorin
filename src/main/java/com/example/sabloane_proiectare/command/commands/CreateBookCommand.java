package com.example.sabloane_proiectare.command.commands;

import com.example.sabloane_proiectare.command.*;
import com.example.sabloane_proiectare.model.Book;

public class CreateBookCommand implements Command {
    private final CommandContext ctx;
    private final Book book;

    public CreateBookCommand(CommandContext ctx, Book book) {
        this.ctx = ctx;
        this.book = book;
    }

    @Override
    public CommandResult execute() {
        Book created = ctx.booksService().create(book);
        return new CommandResult(true, created, "Created");
    }
}

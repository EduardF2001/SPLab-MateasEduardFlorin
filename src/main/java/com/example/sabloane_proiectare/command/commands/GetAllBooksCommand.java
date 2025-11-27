package com.example.sabloane_proiectare.command.commands;

import com.example.sabloane_proiectare.command.*;
import com.example.sabloane_proiectare.model.Book;
import com.example.sabloane_proiectare.service.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command {

    private final CommandContext ctx;

    public GetAllBooksCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public CommandResult execute() {
        List<Book> books = ctx.booksService().getAll();
        return new CommandResult(true, books, "OK");
    }
}

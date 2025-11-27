package com.example.sabloane_proiectare.command.commands;

import com.example.sabloane_proiectare.command.*;
import com.example.sabloane_proiectare.model.Book;

public class UpdateBookCommand implements Command {
    private final CommandContext ctx;
    private final Long id;
    private final Book newData;

    public UpdateBookCommand(CommandContext ctx, Long id, Book newData) {
        this.ctx = ctx;
        this.id = id;
        this.newData = newData;
    }

    @Override
    public CommandResult execute() {
        Book updated = ctx.booksService().update(id, newData);
        if (updated == null) return new CommandResult(false, null, "Not Found");
        return new CommandResult(true, updated, "OK");
    }
}

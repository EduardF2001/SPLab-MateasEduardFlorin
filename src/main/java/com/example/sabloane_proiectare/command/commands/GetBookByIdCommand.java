package com.example.sabloane_proiectare.command.commands;

import com.example.sabloane_proiectare.command.*;
import com.example.sabloane_proiectare.model.Book;

public class GetBookByIdCommand implements Command {
    private final CommandContext ctx;
    private final Long id;

    public GetBookByIdCommand(CommandContext ctx, Long id) {
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    public CommandResult execute() {
        Book b = ctx.booksService().getById(id);
        if (b == null) return new CommandResult(false, null, "Not Found");
        return new CommandResult(true, b, "OK");
    }
}

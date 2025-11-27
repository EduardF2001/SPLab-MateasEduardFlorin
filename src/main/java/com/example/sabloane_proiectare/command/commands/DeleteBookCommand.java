package com.example.sabloane_proiectare.command.commands;

import com.example.sabloane_proiectare.command.*;

public class DeleteBookCommand implements Command {
    private final CommandContext ctx;
    private final Long id;

    public DeleteBookCommand(CommandContext ctx, Long id) {
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    public CommandResult execute() {
        boolean ok = ctx.booksService().delete(id);
        return new CommandResult(ok, null, ok ? "Deleted" : "Not Found");
    }
}

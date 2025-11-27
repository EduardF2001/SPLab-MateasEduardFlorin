package com.example.sabloane_proiectare.command.executor;

import com.example.sabloane_proiectare.command.Command;
import com.example.sabloane_proiectare.command.CommandResult;

import java.util.concurrent.Future;

public interface CommandExecutor {
    Future<CommandResult> execute(Command cmd);
}

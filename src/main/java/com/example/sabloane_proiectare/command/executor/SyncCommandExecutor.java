package com.example.sabloane_proiectare.command.executor;

import com.example.sabloane_proiectare.command.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component("syncExecutor")
public class SyncCommandExecutor implements CommandExecutor {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public Future<CommandResult> execute(Command cmd) {
        return executor.submit(cmd::execute);
    }
}
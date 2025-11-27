package com.example.sabloane_proiectare.command.executor;

import com.example.sabloane_proiectare.command.Command;
import com.example.sabloane_proiectare.command.CommandResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.*;

@Component("asyncExecutor")
public class AsyncCommandExecutor {

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<String, Future<CommandResult>> tasks = new ConcurrentHashMap<>();

    public String submitWithId(Command cmd) {
        String id = UUID.randomUUID().toString();
        Future<CommandResult> future = executor.submit(cmd::execute);
        tasks.put(id, future);
        return id;
    }

    public Future<CommandResult> getTask(String id) {
        return tasks.get(id);
    }
}

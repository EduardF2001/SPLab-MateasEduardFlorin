package com.example.sabloane_proiectare.command.executor;

import com.example.sabloane_proiectare.command.CommandResult;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class AsyncTaskManager {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    private final Map<String, Future<CommandResult>> tasks = new ConcurrentHashMap<>();

    public String submit(Callable<CommandResult> callable) {
        Future<CommandResult> f = executor.submit(callable);
        String id = UUID.randomUUID().toString();
        tasks.put(id, f);
        return id;
    }

    public Future<CommandResult> get(String id) {
        return tasks.get(id);
    }

    public boolean exists(String id) {
        return tasks.containsKey(id);
    }
}

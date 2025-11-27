package com.example.sabloane_proiectare.controllers;

import com.example.sabloane_proiectare.command.*;
import com.example.sabloane_proiectare.command.commands.*;
import com.example.sabloane_proiectare.command.executor.AsyncCommandExecutor;
import com.example.sabloane_proiectare.command.executor.SyncCommandExecutor;
import com.example.sabloane_proiectare.model.Book;
import com.example.sabloane_proiectare.service.BooksService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CommandContext ctx;
    private final SyncCommandExecutor syncExecutor;
    private final AsyncCommandExecutor asyncExecutor;

    public BooksController(BooksService booksService,
                           SyncCommandExecutor syncExecutor,
                           AsyncCommandExecutor asyncExecutor) {
        this.ctx = new CommandContext(booksService);
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
    }

    @GetMapping
    public ResponseEntity<?> getAll() throws Exception {
        Command cmd = new GetAllBooksCommand(ctx);
        Future<CommandResult> future = syncExecutor.execute(cmd);
        return ResponseEntity.ok(future.get().getPayload());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        Command cmd = new GetBookByIdCommand(ctx, id);
        Future<CommandResult> future = syncExecutor.execute(cmd);
        var res = future.get();
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res.getMessage());
        return ResponseEntity.ok(res.getPayload());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book b) {
        Command cmd = new CreateBookCommand(ctx, b);
        // Submit to async executor and get a taskId
        String taskId = asyncExecutor.submitWithId(cmd);
        // Return 202 Accepted with id so client can poll
        return ResponseEntity.accepted()
                .header("Location", "/books/tasks/" + taskId)
                .body("Accepted taskId=" + taskId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book b) throws Exception {
        Command cmd = new UpdateBookCommand(ctx, id, b);
        Future<CommandResult> f = syncExecutor.execute(cmd);
        var res = f.get();
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res.getMessage());
        return ResponseEntity.ok(res.getPayload());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        Command cmd = new DeleteBookCommand(ctx, id);
        Future<CommandResult> f = syncExecutor.execute(cmd);
        var res = f.get();
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res.getMessage());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<?> taskStatus(@PathVariable String taskId) throws Exception {
        var future = asyncExecutor.getClass();
        return ResponseEntity.ok("Implement polling endpoint: inject AsyncTaskManager to check status");
    }
}

package com.example.sabloane_proiectare.service;

import com.example.sabloane_proiectare.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {

    private final Map<Long, Book> store = new ConcurrentHashMap<>();
    private final AtomicLong gen = new AtomicLong(1);

    public List<Book> getAll() {
        return new ArrayList<>(store.values());
    }

    public Book getById(Long id) {
        return store.get(id);
    }

    public Book create(Book b) {
        long id = gen.getAndIncrement();
        Book nb = new Book(id, b.getTitle(), b.getAuthor(), b.getIsbn());
        store.put(id, nb);
        return nb;
    }

    public Book update(Long id, Book b) {
        Book existing = store.get(id);
        if (existing == null) return null;
        existing.setTitle(b.getTitle());
        existing.setAuthor(b.getAuthor());
        existing.setIsbn(b.getIsbn());
        store.put(id, existing);
        return existing;
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
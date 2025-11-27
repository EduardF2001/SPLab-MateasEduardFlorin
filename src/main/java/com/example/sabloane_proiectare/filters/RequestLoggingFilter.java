package com.example.sabloane_proiectare.filters;

import jakarta.servlet.*;
import jakarta.servlet.Filter;
import jakarta.servlet.http.*;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;

@Component
public class RequestLoggingFilter implements Filter {

    private final Path logFile = Paths.get("logs", "requests.log");

    public RequestLoggingFilter() {
        try {
            Files.createDirectories(logFile.getParent());
            if (!Files.exists(logFile)) {
                Files.createFile(logFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String before = String.format("%s - BEFORE - %s %s from %s%n",
                Instant.now(), req.getMethod(), req.getRequestURI(), req.getRemoteAddr());
        Files.write(logFile, before.getBytes(), StandardOpenOption.APPEND);
        try {
            chain.doFilter(request, response);
        } finally {
            String after = String.format("%s - AFTER  - %s %s from %s%n",
                    Instant.now(), req.getMethod(), req.getRequestURI(), req.getRemoteAddr());
            Files.write(logFile, after.getBytes(), StandardOpenOption.APPEND);
        }
    }
}
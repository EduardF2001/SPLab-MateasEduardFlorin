package com.example.sabloane_proiectare.difexample;

import com.example.sabloane_proiectare.singleton.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record HelloController(ClientComponent clientComponent) {

    @GetMapping("/")
    public String helloClient() {
        return "Hello from ClientComponent = " + "ClientComponent@8d7b252";
    }
}
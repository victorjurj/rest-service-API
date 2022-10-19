package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService service;

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return service.getGreeting(name);
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return service.addGreeting(counter, template, name);
    }

    @DeleteMapping("/greeting")
    public Greeting deleteGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return service.deleteGreeting(name);
    }
}
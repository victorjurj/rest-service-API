package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    List<Greeting> greetings = new ArrayList<>();

    public Greeting getGreeting(String name) {
        return greetings.stream().filter(greeting -> greeting.getContent().contains(name)).findAny().orElse(null);
    }

    public Greeting addGreeting(AtomicLong counter, String template, String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greetings.add(greeting);

        return greeting;
    }

    public Greeting deleteGreeting(String name) {
        Greeting greeting = greetings.stream().filter(g -> g.getContent().contains(name)).findAny().get();
        greetings.remove(greeting);

        return greeting;
    }

}

package com.cloudcenturion.springdemo.controller;

import com.cloudcenturion.springdemo.domain.RestHello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/rest")
public class HomeRest {
    private static final String template = "Rest Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public RestHello greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new RestHello(counter.incrementAndGet(),
                String.format(template, name));
    }
}

package com.cloudcenturion.springdemo.domain;

public class RestHello {
    private final long id;
    private final String content;

    public RestHello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

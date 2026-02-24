package com.example.demo.model;

public class User {
    private Long id;
    private String name;

    // 构造函数
    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter 和 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
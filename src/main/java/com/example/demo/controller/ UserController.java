package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // 模拟内存存储
    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private Long currentId = 1L;

    // GET /api/users - 获取所有用户
    @GetMapping
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    // POST /api/users - 创建用户
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }
}
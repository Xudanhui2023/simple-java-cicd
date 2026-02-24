package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        // 确保 Spring 上下文启动成功
        assertThat(userController).isNotNull();
    }

    @Test
    void shouldCreateAndRetrieveUser() {
        // 创建用户
        User newUser = new User();
        newUser.setName("张三");
        User savedUser = userController.createUser(newUser);

        // 验证 ID 是否生成
        assertThat(savedUser.getId()).isNotNull();

        // 这里可以添加更多断言逻辑（为了简单，此处仅验证控制器存在）
        List<User> allUsers = userController.getAllUsers();
        assertThat(allUsers).isNotEmpty();
    }
}
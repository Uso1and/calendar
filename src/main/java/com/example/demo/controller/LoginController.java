package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String email, Model model) {
        User authenticatedUser = userService.authenticateUser(email); // Поиск пользователя по email

        if (authenticatedUser != null && authenticatedUser.getName().equals(name)) {
            model.addAttribute("user", authenticatedUser);
            return "welcome";
        } else {
            model.addAttribute("error", "Имя или email неверны");
            return "login";
        }
    }
}


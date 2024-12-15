package com.example.demo.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // Вернуть кастомный шаблон ошибки
        return "error"; // Убедитесь, что у вас есть error.html в папке templates
    }
}
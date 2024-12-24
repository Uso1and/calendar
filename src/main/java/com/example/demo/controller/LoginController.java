package com.example.demo.controller;

import com.example.demo.entity.Day;
import com.example.demo.entity.User;
import com.example.demo.service.CalendarService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String email, Model model) {
        User authenticatedUser = userService.authenticateUser(email);

        if (authenticatedUser != null && authenticatedUser.getName().equals(name)) {
            model.addAttribute("user", authenticatedUser);
            List<Day> days = calendarService.getAllDays();
            model.addAttribute("days", days);
            return "welcome";
        } else {
            model.addAttribute("error", "Имя или email неверны");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        List<Day> days = calendarService.getAllDays();
        model.addAttribute("days", days);
        return "welcome";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, Model model) {
        Optional<User> existingUser = userService.findUserByEmail(email);
        if (existingUser.isPresent()) {
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "register";
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);

        userService.createUser(newUser);

        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        return "register";
    }
}

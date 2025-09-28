package com.mySite.MyJavaSite.controllers;

import com.mySite.MyJavaSite.Service.EmailServise;
import com.mySite.MyJavaSite.Service.UserService;
import com.mySite.MyJavaSite.models.Users;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "BMW R1300GS");
        model.addAttribute("users", new Users());
        return "index";
    }

    @GetMapping("/GSTrophy")
    public String GSTrophy(Model model) {
        model.addAttribute("title", "BMW GSTrophy");
        model.addAttribute("users", new Users());
        return "GSTrophy";
    }

    @GetMapping("/TripleBlack")
    public String TripleBlack(Model model) {
        model.addAttribute("title", "BMW TripleBlack");
        model.addAttribute("users", new Users());
        return "TripleBlack";
    }

    private final EmailServise emailServise;
    private final UserService userService;
    @Autowired
    public MainController(EmailServise emailServise, UserService userService) {
        this.emailServise = emailServise;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public String submitUsersForm(@ModelAttribute Users users, Model model) {
        userService.saveUser(users);
        model.addAttribute("index", "Изменения сохранены!");

        try {
            String usersEmail = users.getEmail();
            String clientData = String.format(
                    "Имя: %s\nФамилия: %s\nТелефон: %s\nEmail: %s",
                    users.getName(), users.getSecond_name(), users.getPhone(), users.getEmail()
            );
            emailServise.sendClientDataEmail(usersEmail, users.getName(), clientData);

            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при сохранении: " + e.getMessage());
            return "index";
        }
    }

    @PostMapping("/GSTrophy/submit")
    public String submitUsersFormGSTrophy(@ModelAttribute Users users, Model model) {
        userService.saveUser(users);
        model.addAttribute("GSTrophy", "Изменения сохранены!");

        try {
            String usersEmail = users.getEmail();
            String clientData = String.format(
                    "Имя: %s\nФамилия: %s\nТелефон: %s\nEmail: %s",
                    users.getName(), users.getSecond_name(), users.getPhone(), users.getEmail()
            );
            emailServise.sendClientDataEmail(usersEmail, users.getName(), clientData);

            return "GSTrophy";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при сохранении: " + e.getMessage());
            return "GSTrophy";
        }
    }

    @PostMapping("/TripleBlack/submit")
    public String submitUsersFormTripleBlack(@ModelAttribute Users users, Model model) {
        userService.saveUser(users);
        model.addAttribute("TripleBlack", "Изменения сохранены!");

        try {
            String usersEmail = users.getEmail();
            String clientData = String.format(
                    "Имя: %s\nФамилия: %s\nТелефон: %s\nEmail: %s",
                    users.getName(), users.getSecond_name(), users.getPhone(), users.getEmail()
            );
            emailServise.sendClientDataEmail(usersEmail, users.getName(), clientData);

            return "TripleBlack";
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при сохранении: " + e.getMessage());
            return "TripleBlack";
        }
    }
}

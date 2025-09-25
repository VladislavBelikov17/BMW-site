package com.mySite.MyJavaSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "BMW R1300GS");
        return "index";
    }

    @GetMapping("/GSTrophy")
    public String GSTrophy(Model model) {
        model.addAttribute("title", "BMW GSTrophy");
        return "GSTrophy";
    }

    @GetMapping("/TripleBlack")
    public String TripleBlack(Model model) {
        model.addAttribute("title", "BMW TripleBlack");
        return "TripleBlack";
    }
}

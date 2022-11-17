package com.example.Proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/home")
    public String index(@RequestParam(name = "id", required = false, defaultValue = "Привет") String text, Model model) {
        model.addAttribute("temp", text);

        System.out.println(text);
        return "home";
    }
    @PostMapping("/home")
    public String index2(@RequestParam(name = "id", required = false, defaultValue = "Привет") String text, Model model) {
        model.addAttribute("temp", text);
        System.out.println(text);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

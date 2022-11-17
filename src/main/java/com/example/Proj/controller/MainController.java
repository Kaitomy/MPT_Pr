package com.example.Proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/home")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "Привет") String id, Model model) {
        model.addAttribute("temp", id);

        System.out.println(id);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

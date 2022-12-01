package com.example.Proj.controller;

import com.example.Proj.Models.Astronom;
import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Star;
import com.example.Proj.Repository.AstronomRepository;
import com.example.Proj.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManyController {
    @Autowired
    private AstronomRepository astronomRepository;
    @Autowired
    private StarRepository starRepository;

    @GetMapping("/many")
    private String Main(Model model){
        Iterable<Astronom> astronom = astronomRepository.findAll();
        model.addAttribute("astronom", astronom);
        Iterable<Star> star = starRepository.findAll();
        model.addAttribute("star", star);

        return "many";
    }

    @PostMapping("/many/add")
    public String blogPostAdd(@RequestParam String astronom, @RequestParam String star, Model model)
    {
        Astronom astronom2 = astronomRepository.findByName(astronom);
        Star star2 = starRepository.findByName(star);

        astronom2.getStar().add(star2);
        astronomRepository.save(astronom2);
        return "redirect:/many";
    }
}
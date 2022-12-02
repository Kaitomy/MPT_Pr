package com.example.Proj.controller;

import com.example.Proj.Models.Constellations;
import com.example.Proj.Models.Stars;
import com.example.Proj.Repository.ConstellationsRepository;
import com.example.Proj.Repository.StarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAnyAuthority('EDITOR')")
public class StarsController {
    @Autowired
    public ConstellationsRepository constellationsRepository;
    @Autowired
    public StarsRepository starsRepository;

    @GetMapping("/star_c")
    public String Main(Model model){
        Iterable<Constellations> constellations = constellationsRepository.findAll();
        model.addAttribute("constellations",constellations);
        return "star_c";
    }

    @PostMapping("/star_c/add")
    public String blogPostAdd(@RequestParam String name,@RequestParam String znak, @RequestParam String constellationsname, Model model)
    {

        Constellations constellationsL = constellationsRepository.findByConstellationsname(constellationsname);
        Stars stars = new Stars(name,znak, constellationsL);
        starsRepository.save(stars);
        return "redirect:/star_c";
    }
}

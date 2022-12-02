package com.example.Proj.controller;

import com.example.Proj.Models.Astronom;
import com.example.Proj.Models.Planet;
import com.example.Proj.Repository.AstronomRepository;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@PreAuthorize("hasAnyAuthority('EDITOR')")
public class AstronomController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private AstronomRepository astronomRepository;

    @GetMapping("/astronom")
    public String Main(Model model){
        Iterable<Planet> planet = planetRepository.findAll();
        ArrayList<Planet> planetArrayList = new ArrayList<>();
        for (Planet pass: planet) {
            if (pass.getAstronom() == null) {
                planetArrayList.add(pass);
            }
        }

        model.addAttribute("planet", planetArrayList);
        return "astronom";
    }

    @PostMapping("/astronom/add")
    public String blogPostAdd(@RequestParam String name,@RequestParam String country,@RequestParam Integer years, @RequestParam String planetname, Model model)
    {
        System.out.println(name);
        Planet planet = planetRepository.findByPlanetname(planetname);
        System.out.println(planet.getPlanetID());
        Astronom astronom = new Astronom(name,country,years,planet);
        astronomRepository.save(astronom);
        return "redirect:/astronom";
    }
}

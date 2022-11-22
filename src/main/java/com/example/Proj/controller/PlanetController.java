package com.example.Proj.controller;
import com.example.Proj.Models.Planet;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/planet")
public class PlanetController {
    final
    PlanetRepository planetRepository;

    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }



    @GetMapping("/")
    public String indexPlanet(Model model){
        Iterable<Planet> planetIterable =  planetRepository.findAll();
        model.addAttribute("planet_list",planetIterable);
        return "planet/index_planet";
    }
    @PostMapping("/add")
    public String AddPlanet ( @RequestParam(name = "Planet_Name") String Planet_Name,
                            @RequestParam(name = "Planet_Mass") int Planet_Mass,
                            @RequestParam(name = "Planet_Age") int Planet_Age,
                              @RequestParam(name = "Planet_Sistem") String Planet_Sistem,
                              @RequestParam(name = "Planet_Life") String Planet_Life

    )
    {
        Planet new_planet = new Planet(Planet_Name,Planet_Mass,Planet_Age,Planet_Sistem,Planet_Life);
        planetRepository.save(new_planet);
        return "redirect:/planet/";
    }
    @GetMapping("/add")
    public String AddView()
    {
        return "planet/planet-add";
    }

    @GetMapping("/planet-find")
    public String findByNamePlanet(
            @RequestParam(name = "Planet_Name",required = true, defaultValue = "") String Planet_Name,
            Model model)
    {
        //Iterable<Planet> planetIterable =  planetRepository.findByNamePlanet(Planet_Name);
     //  model.addAttribute("planet_list",planetIterable);
        return "planet/index_planet";
    }

}




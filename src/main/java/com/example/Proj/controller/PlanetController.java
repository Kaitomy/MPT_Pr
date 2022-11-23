package com.example.Proj.controller;
import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Star;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/filter/")
    public String filter(@RequestParam(name="planetname") String planet_name, Model model)
    {
       List<Planet> planetList = planetRepository.findByPlanetname(planet_name);
        model.addAttribute("planet_list",planetList);
        return "planet/index_planet";
    }
    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="planetname") String planet_name,
            Model model)
    {
        List<Planet> planetList = planetRepository.findByPlanetnameContains(planet_name);
        model.addAttribute("planet_list",planetList);
        return "planet/index_planet";
    }
    @GetMapping("/detail/{id}")
    public String detailPlanet(
            @PathVariable Long id,
            Model model
    ){
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        model.addAttribute("one_planet",planet_obj);
        return "planet/info-planet";
    }
    @GetMapping("/detail/{id}/del")
    public String delPlanet(@PathVariable Long id)
    {
        Planet planet_obj = planetRepository.findById(id).orElseThrow();
        planetRepository.delete(planet_obj);
        return "redirect:/planet/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Model model
    )
    {
        model.addAttribute(
                "object",
                planetRepository.findById(id).orElseThrow()
        );
        return "planet/update-planet";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update(
            @PathVariable Long id,
            @RequestParam String planetname,
            @RequestParam Integer Planet_Mass,
            @RequestParam Integer Planet_Age,
            @RequestParam String planetsistem,
            @RequestParam String Planet_Life
    )
    {
        Planet planet = planetRepository.findById(id).orElseThrow();

        planet.setPlanetname(planetname);
        planet.setPlanet_Mass(Planet_Mass);
        planet.setPlanet_Age(Planet_Age);
        planet.setPlanetsistem(planetsistem);
        planet.setPlanet_Life(Planet_Life);
        planetRepository.save(planet);
        return "redirect:/planet/detail/" + planet.getPlanetID();
    }
}




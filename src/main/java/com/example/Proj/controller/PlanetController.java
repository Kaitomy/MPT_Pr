package com.example.Proj.controller;
import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Star;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/planet")
@PreAuthorize("hasAnyAuthority('USER')")
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
    public String AddPlanet (@Valid Planet planet, BindingResult bindingResult) {
        if (planet.getPlanetname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "planet/planet-add";
        }

        planetRepository.save(planet);
        return "redirect:/planet/";
    }
    @GetMapping("/add")
    public String AddView(Planet planet)
    {
        return "planet/planet-add";
    }

//    @GetMapping("/filter/")
//    public String filter(@RequestParam(name="planetname") String planet_name, Model model)
//    {
//       List<Planet> planetList = planetRepository.findByPlanetname(planet_name);
//        model.addAttribute("planet_list",planetList);
//        return "planet/index_planet";
//    }
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
            Planet planet,
            Model model
    )
    {
        planet= planetRepository.findById(id).orElseThrow();
        model.addAttribute("planet",planet);
        return "planet/update-planet";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid Planet planet, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "planet/update-planet";
    }

        planetRepository.save(planet);

        return "redirect:/planet/detail/" + planet.getPlanetID();
    }


}




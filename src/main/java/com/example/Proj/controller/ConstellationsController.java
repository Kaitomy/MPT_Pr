package com.example.Proj.controller;

import com.example.Proj.Models.Constellations;
import com.example.Proj.Repository.ConstellationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/constellations")
public class ConstellationsController {
    @Autowired
    ConstellationsRepository constellationsRepository;
    @GetMapping("/")
    public String indexConstellations(Model model){
        Iterable<Constellations> constellationsIterable =  constellationsRepository.findAll();
        model.addAttribute("constellations_list",constellationsIterable);
        return "constellations/index_constellations";
    }
    @PostMapping("/add")
    public String AddConstellations ( @RequestParam(name = "Constellations_Name") String Constellations_Name,
                              @RequestParam(name = "Constellations_Number") int Constellations_Number,
                              @RequestParam(name = "Constellations_Hemisphere") String Constellations_Hemisphere,
                              @RequestParam(name = "Constellations_Season") String Constellations_Season,
                              @RequestParam(name = "Constellations_Type") String Constellations_Type

    )
    {
        Constellations new_constellations = new Constellations(Constellations_Name,Constellations_Number,Constellations_Hemisphere,Constellations_Season,Constellations_Type);
        constellationsRepository.save(new_constellations);
        return "redirect:/constellations/";
    }
    @GetMapping("/add")
    public String AddView()
    {
        return "constellations/constellations-add";
    }
}


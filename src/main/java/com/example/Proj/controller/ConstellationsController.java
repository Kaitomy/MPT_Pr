package com.example.Proj.controller;

import com.example.Proj.Models.Constellations;
import com.example.Proj.Models.Planet;
import com.example.Proj.Repository.ConstellationsRepository;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/constellations")
public class ConstellationsController {
    @Autowired
    ConstellationsRepository constellationsRepository;
    public ConstellationsController(ConstellationsRepository constellationsRepository) {
        this.constellationsRepository = constellationsRepository;
    }

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

    @GetMapping("/filter/")
    public String filter(@RequestParam(name="constellationsname") String constellations_name, Model model)
    {
        List<Constellations> constellationsList = constellationsRepository.findByConstellationsname(constellations_name);
        model.addAttribute("constellations_list",constellationsList);
        return "constellations/index_constellations";
    }
    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="constellationsname") String constellations_name,
            Model model)
    {
        List<Constellations> constellationsList = constellationsRepository.findByConstellationsnameContains(constellations_name);
        model.addAttribute("constellations_list",constellationsList);
        return "constellations/index_constellations";
    }

    @GetMapping("/detail/{id}")
    public String detailConstellations(
            @PathVariable Long id,
            Model model
    ){
        Constellations constellations_obj = constellationsRepository.findById(id).orElseThrow();
        model.addAttribute("one_constellations",constellations_obj);
        return "constellations/info-constellations";
    }
    @GetMapping("/detail/{id}/del")
    public String delConstellations(@PathVariable Long id)
    {
        Constellations constellations_obj = constellationsRepository.findById(id).orElseThrow();
        constellationsRepository.delete(constellations_obj);
        return "redirect:/constellations/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Model model
    )
    {
        model.addAttribute(
                "object",
                constellationsRepository.findById(id).orElseThrow()
        );
        return "constellations/update-constellations";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update(
            @PathVariable Long id,
            @RequestParam String constellationsname,
            @RequestParam Integer Constellations_Number,
            @RequestParam String Constellations_Hemisphere,
            @RequestParam String Constellations_Season,
            @RequestParam String Constellations_Type
    )
    {
        Constellations constellations = constellationsRepository.findById(id).orElseThrow();

        constellations.setConstellationsname(constellationsname);
        constellations.setConstellations_Number(Constellations_Number);
        constellations.setConstellations_Hemisphere(Constellations_Hemisphere);
        constellations.setConstellations_Season(Constellations_Season);
        constellations.setConstellations_Type(Constellations_Type);
        constellationsRepository.save(constellations);
        return "redirect:/constellations/detail/" + constellations.getConstellationsID();
    }
}


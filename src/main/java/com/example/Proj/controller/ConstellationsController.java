package com.example.Proj.controller;

import com.example.Proj.Models.Constellations;
import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Star;
import com.example.Proj.Repository.ConstellationsRepository;
import com.example.Proj.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String AddConstellations (@Valid Constellations constellations, BindingResult bindingResult)
    {
        if (constellations.getConstellationsname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "constellations/constellations-add";
        }

        constellationsRepository.save(constellations);
        return "redirect:/constellations/";
    }
    @GetMapping("/add")
    public String AddView(Constellations constellations)
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
            Constellations constellations,
            Model model
    )
    {
        constellations =  constellationsRepository.findById(id).orElseThrow();
        model.addAttribute("constellations",constellations);
        return "constellations/update-constellations";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update(  @Valid Constellations constellations, BindingResult bindingResult, Model model
    )
    {
        if (bindingResult.hasErrors()) {
            return "constellations/update-constellations";
        }

        constellationsRepository.save(constellations);

        return "redirect:/constellations/detail/" + constellations.getConstellationsID();
    }
}


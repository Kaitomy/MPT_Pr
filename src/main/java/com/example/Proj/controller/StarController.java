package com.example.Proj.controller;

import com.example.Proj.Models.Star;
import com.example.Proj.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/star")
public class StarController {
    @Autowired
    StarRepository starRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Star> starIterable = starRepository.findAll();
        model.addAttribute("star_list", starIterable);
        return "star/index";
    }

    @PostMapping("/add")
    public String AddStar(@Valid Star star, BindingResult bindingResult) {
        if (star.getName().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "star/star-add";
        }

        starRepository.save(star);
        return "redirect:/star/";
    }

//    @GetMapping("/filter/")
//    public String filter(@RequestParam(name = "name") String name_star, Model model) {
//        List<Star> starList = starRepository.findByName(name_star);
//        model.addAttribute("star_list", starList);
//        return "star/index";
//    }

    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name = "name") String name_star,
            Model model) {
        List<Star> starList = starRepository.findByNameContains(name_star);
        model.addAttribute("star_list", starList);
        return "star/index";
    }

    @GetMapping("/detail/{id}")
    public String detailStar(
            @PathVariable Long id,
            Model model
    ) {
        Star star_obj = starRepository.findById(id).orElseThrow();
        model.addAttribute("one_star", star_obj);
        return "star/info";
    }

    @GetMapping("/detail/{id}/del")
    public String delStar(@PathVariable Long id) {
        Star star_obj = starRepository.findById(id).orElseThrow();
        starRepository.delete(star_obj);
        return "redirect:/star/";
    }

    @GetMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            Star star,
            Model model
    ) {
        star = starRepository.findById(id).orElseThrow();
        model.addAttribute("star",star);

        return "star/update";
    }

    @PostMapping("/detail/{id}/upd")
    public String update(
            @Valid Star star, BindingResult bindingResult, Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "star/update";
        }

        starRepository.save(star);

        return "redirect:/star/detail/" + star.getUID();
    }

    @GetMapping("/add")
    public String AddView(Star star) {
        return "star/star-add";
    }
}

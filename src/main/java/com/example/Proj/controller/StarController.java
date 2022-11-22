package com.example.Proj.controller;

import com.example.Proj.Models.Star;
import com.example.Proj.Repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/star")
public class StarController {
    @Autowired
    StarRepository starRepository;
    @GetMapping("/")
    public String index(Model model){
      Iterable<Star> starIterable =  starRepository.findAll();
      model.addAttribute("star_list",starIterable);
        return "star/index";
    }
    @PostMapping("/add")
    public String AddStar ( @RequestParam(name = "name") String name,
        @RequestParam(name = "class") String class_star,
        @RequestParam(name = "lumen") int lumen

        )
    {
Star new_star = new Star(name,class_star,lumen);
starRepository.save(new_star);
return "redirect:/star/";
    }
    @GetMapping("/add")
    public String AddView()
    {
        return "star/star-add";
    }
}

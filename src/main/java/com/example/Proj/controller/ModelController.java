package com.example.Proj.controller;


import com.example.Proj.Models.Mark;
import com.example.Proj.Repository.MarkRepository;
import com.example.Proj.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/model")
//@PreAuthorize("hasAnyAuthority('EDITOR')")
public class ModelController {
    @Autowired
    public MarkRepository markRepository;
    @Autowired
    public ModelRepository modelRepository;

    @GetMapping("/model")
    public String Main(Model model){
        Iterable<Mark> mark = markRepository.findAll();
        model.addAttribute("mark",mark);
        return "model/model-add";
    }
    @GetMapping("/model/info")
    public String indexMark(Model model){
        Iterable<com.example.Proj.Models.Model> modelIterable =  modelRepository.findAll();
        model.addAttribute("model_list",modelIterable);
        return "model/index_model";
    }
    @PostMapping("/model/add")
    public String ModelAdd(@RequestParam String modelname,@RequestParam String modeldesc, @RequestParam String markname, Model model)
    {

        Mark markL = markRepository.findByMarkname(markname);
        com.example.Proj.Models.Model model1 = new com.example.Proj.Models.Model(modelname,modeldesc, markL);
        modelRepository.save(model1);
        return "redirect:/model/info";
    }
}

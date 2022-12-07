package com.example.Proj.controller;

import com.example.Proj.Models.Additional;
import com.example.Proj.Models.Mark;
import com.example.Proj.Repository.AdditionalRepository;
import com.example.Proj.Repository.MarkRepository;
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
@PreAuthorize("hasAnyAuthority('SELLER')")
@RequestMapping("/additional")
//@PreAuthorize("hasAnyAuthority('USER')")
public class AdditionalController {
    final
    AdditionalRepository additionalRepository;

    public AdditionalController(AdditionalRepository additionalRepository) {
        this.additionalRepository = additionalRepository;
    }



    @GetMapping("/")
    public String indexAdditional(Model model){
        Iterable<Additional> additionalIterable =  additionalRepository.findAll();
        model.addAttribute("additional_list",additionalIterable);
        return "additional/index_additional";
    }
    @PostMapping("/add")
    public String AddAdditional (@Valid Additional additional, BindingResult bindingResult) {
        if (additional.getAdditionalname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "additional/additional-add";
        }

        additionalRepository.save(additional);
        return "redirect:/additional/";
    }
    @GetMapping("/add")
    public String AddView(Additional additional)
    {
        return "additional/additional-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="additionalname") String additionalname,
            Model model)
    {
        List<Additional> additionalList = additionalRepository.findByAdditionalnameContains(additionalname);
        model.addAttribute("additional_list",additionalList);
        return "additional/index_additional";
    }
    @GetMapping("/detail/{id}")
    public String detailAdditional(
            @PathVariable Long id,
            Model model
    ){
        Additional additional_obj = additionalRepository.findById(id).orElseThrow();
        model.addAttribute("one_additional",additional_obj);
        return "additional/info-additional";
    }
    @GetMapping("/detail/{id}/del")
    public String delAdditional(@PathVariable Long id)
    {
        Additional additional_obj = additionalRepository.findById(id).orElseThrow();
        additionalRepository.delete(additional_obj);
        return "redirect:/additional/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Additional additional,
            Model model
    )
    {
        additional= additionalRepository.findById(id).orElseThrow();
        model.addAttribute("additional",additional);
        return "additional/update-additional";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid Additional additional, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "additional/update-additional";
    }

        additionalRepository.save(additional);

        return "redirect:/additional/detail/" + additional.getAdditionalID();
    }


}

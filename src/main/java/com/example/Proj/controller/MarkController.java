package com.example.Proj.controller;

import com.example.Proj.Models.Mark;
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
@RequestMapping("/mark")
//@PreAuthorize("hasAnyAuthority('USER')")
public class MarkController {
    final
    MarkRepository markRepository;

    public MarkController(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }



    @GetMapping("/")
    public String indexMark(Model model){
        Iterable<Mark> markIterable =  markRepository.findAll();
        model.addAttribute("mark_list",markIterable);
        return "mark/index_mark";
    }
    @PostMapping("/add")
    public String AddMark (@Valid Mark mark, BindingResult bindingResult) {
        if (mark.getMarkname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "mark/mark-add";
        }

        markRepository.save(mark);
        return "redirect:/mark/";
    }
    @GetMapping("/add")
    public String AddView(Mark mark)
    {
        return "mark/mark-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="markname") String markname,
            Model model)
    {
        List<Mark> markList = markRepository.findByMarknameContains(markname);
        model.addAttribute("mark_list",markList);
        return "mark/index_mark";
    }
    @GetMapping("/detail/{id}")
    public String detailMark(
            @PathVariable Long id,
            Model model
    ){
        Mark mark_obj = markRepository.findById(id).orElseThrow();
        model.addAttribute("one_mark",mark_obj);
        return "mark/info-mark";
    }
    @GetMapping("/detail/{id}/del")
    public String delMark(@PathVariable Long id)
    {
        Mark mark_obj = markRepository.findById(id).orElseThrow();
        markRepository.delete(mark_obj);
        return "redirect:/mark/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Mark mark,
            Model model
    )
    {
        mark= markRepository.findById(id).orElseThrow();
        model.addAttribute("mark",mark);
        return "mark/update-mark";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid Mark mark, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "mark/update-mark";
    }

        markRepository.save(mark);

        return "redirect:/mark/detail/" + mark.getMarkID();
    }


}

package com.example.Proj.controller;


import com.example.Proj.Models.*;
import com.example.Proj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
@PreAuthorize("hasAnyAuthority('SELLER','USER')")
@Controller
//@RequestMapping("/model")
//@PreAuthorize("hasAnyAuthority('EDITOR')")
public class FeedbackController {
    @Autowired
    public TovarRepository tovarRepository;
    @Autowired
    public FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public String Main(Model model){
        Iterable<Tovar> tovar = tovarRepository.findAll();
        model.addAttribute("tovar",tovar);
        return "feedback/feedback-add";
    }
    @GetMapping("/feedback/info")
    public String indexTovar(Model model){
        Iterable<Feedback> feedbackIterable =  feedbackRepository.findAll();
        model.addAttribute("feedback_list",feedbackIterable);
        return "feedback/index_feedback";
    }
    @PostMapping("/feedback/add")
    public String FeedbackAdd(@RequestParam String feedbackdesc, @RequestParam Date feedbackdate, @RequestParam String tovarname, Model model)
    {
       Tovar tovarL = tovarRepository.findByTovarname(tovarname);
        Feedback feedback = new Feedback(feedbackdesc,feedbackdate, tovarL);
        feedbackRepository.save(feedback);
        return "redirect:/feedback/info";
    }


    @GetMapping("/feedback/detail/{id}")
    public String detailFeedback(
            @PathVariable Long id,
            Model model
    ){
        Feedback feedback_obj = feedbackRepository.findById(id).orElseThrow();
        model.addAttribute("one_feedback",feedback_obj);
        return "feedback/info-feedback";
    }

}
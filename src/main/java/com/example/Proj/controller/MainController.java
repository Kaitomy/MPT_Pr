package com.example.Proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    float itog1;

    @GetMapping("/home")
    public String index(@RequestParam(required = false) float number, float number2, String action, Model model) {


            if (action.contains("P")) {
                itog1 = number + number2;
            }
            if (action.contains("M")) {
                itog1 = number - number2;
            }
            if (action.contains("Y")) {
                itog1 = number * number2;
            }
            if (action.contains("D")) {
                itog1 = number / number2;
            }
            model.addAttribute("number", number);
            model.addAttribute("number2", number2);
            model.addAttribute("itog1", itog1);
            return "home";


    }

    @PostMapping("/about")
    public String index2(@RequestParam(required = false) float number, float number2, String action, Model model) {
        if (action.contains("P")) {
            itog1 = number + number2;
        }
        if (action.contains("M")) {
            itog1 = number - number2;
        }
        if (action.contains("Y")) {
            itog1 = number * number2;
        }
        if (action.contains("D")) {
            itog1 = number / number2;
        }
        model.addAttribute("number", number);
        model.addAttribute("number2", number2);
        model.addAttribute("itog1", itog1);
        return "about";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


}

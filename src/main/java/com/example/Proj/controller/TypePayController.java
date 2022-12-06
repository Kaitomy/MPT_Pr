package com.example.Proj.controller;

import com.example.Proj.Models.Additional;
import com.example.Proj.Models.Type;
import com.example.Proj.Models.TypePay;
import com.example.Proj.Repository.TypePayRepository;
import com.example.Proj.Repository.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/typepay")
//@PreAuthorize("hasAnyAuthority('USER')")
public class TypePayController {
    final
    TypePayRepository typepayRepository;

    public TypePayController(TypePayRepository typepayRepository) {
        this.typepayRepository = typepayRepository;
    }



    @GetMapping("/")
    public String indexTypePay(Model model){
        Iterable<TypePay> typepayIterable =  typepayRepository.findAll();
        model.addAttribute("typepay_list",typepayIterable);
        return "typepay/index_typepay";
    }
    @PostMapping("/add")
    public String AddTypePay(@Valid TypePay typepay, BindingResult bindingResult) {
        if (typepay.getTypepayname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "typepay/typepay-add";
        }

        typepayRepository.save(typepay);
        return "redirect:/typepay/";
    }
    @GetMapping("/add")
    public String AddView(TypePay typepay)
    {
        return "typepay/typepay-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="typepayname") String typepayname,
            Model model)
    {
        List<TypePay> typepayList = typepayRepository.findByTypepaynameContains(typepayname);
        model.addAttribute("typepay_list",typepayList);
        return "typepay/index_typepay";
    }
    @GetMapping("/detail/{id}")
    public String detailTypePay(
            @PathVariable Long id,
            Model model
    ){
        TypePay typepay_obj = typepayRepository.findById(id).orElseThrow();
        model.addAttribute("one_typepay",typepay_obj);
        return "typepay/info-typepay";
    }
    @GetMapping("/detail/{id}/del")
    public String delTypePay(@PathVariable Long id)
    {
        TypePay typepay_obj = typepayRepository.findById(id).orElseThrow();
        typepayRepository.delete(typepay_obj);
        return "redirect:/typepay/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            TypePay typepay,
            Model model
    )
    {
        typepay= typepayRepository.findById(id).orElseThrow();
        model.addAttribute("typepay",typepay);
        return "typepay/update-typepay";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid TypePay typepay, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "typepay/update-typepay";
    }

        typepayRepository.save(typepay);

        return "redirect:/typepay/detail/" + typepay.getTypePayID();
    }


}

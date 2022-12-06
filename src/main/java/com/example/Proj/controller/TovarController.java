package com.example.Proj.controller;


import com.example.Proj.Models.*;
import com.example.Proj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/model")
//@PreAuthorize("hasAnyAuthority('EDITOR')")
public class TovarController {
    @Autowired
    public ModelRepository modelRepository;
    @Autowired
    public TovarRepository tovarRepository;
    @Autowired
    public TypeRepository typeRepository;
    @Autowired
    public ServiceDeliveryRepository servicedeliveryRepository;
    @Autowired
    public SkladRepository skladRepository;

    @GetMapping("/tovar")
    public String Main(Model model){
        Iterable<com.example.Proj.Models.Model> models = modelRepository.findAll();
        model.addAttribute("model",models);
        Iterable<Type> type = typeRepository.findAll();
        model.addAttribute("type",type);
        Iterable<ServiceDelivery> servicedelivery = servicedeliveryRepository.findAll();
        model.addAttribute("servicedelivery",servicedelivery);
        Iterable<Sklad> sklad = skladRepository.findAll();
        model.addAttribute("sklad",sklad);
        return "tovar/tovar-add";
    }
    @GetMapping("/tovar/info")
    public String indexTovar(Model model){
        Iterable<Tovar> tovarIterable =  tovarRepository.findAll();
        model.addAttribute("tovar_list",tovarIterable);
        return "tovar/index_tovar";
    }
    @PostMapping("/tovar/add")
    public String TovarAdd(@RequestParam String tovarname,@RequestParam String tovarcolour, @RequestParam Integer tovarprice, @RequestParam String modelname,@RequestParam String typename,@RequestParam String servicename,@RequestParam String skladname, Model model)
    {

        com.example.Proj.Models.Model modelL = modelRepository.findByModelname(modelname);
        Type typeL = typeRepository.findByTypename(typename);
        ServiceDelivery serviceL = servicedeliveryRepository.findByServicename(servicename);
        Sklad skladL = skladRepository.findBySkladname(skladname);
        Tovar tovar = new Tovar(tovarname,tovarcolour,tovarprice,typeL,skladL,modelL,serviceL);
        tovarRepository.save(tovar);
        return "redirect:/tovar/info";
    }


    @GetMapping("/tovar/detail/{id}")
    public String detailTovar(
            @PathVariable Long id,
            Model model
    ){
        Tovar tovar_obj = tovarRepository.findById(id).orElseThrow();
        model.addAttribute("one_tovar",tovar_obj);
        return "tovar/info-tovar";
    }
    @GetMapping("/tovar/detail/{id}/del")
    public String delTovar(@PathVariable Long id)
    {
        Tovar tovar_obj = tovarRepository.findById(id).orElseThrow();
        tovarRepository.delete(tovar_obj);
        return "redirect:/tovar/info";
    }
}

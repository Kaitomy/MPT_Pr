package com.example.Proj.controller;

import com.example.Proj.Models.Additional;
import com.example.Proj.Models.Type;
import com.example.Proj.Repository.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/type")
//@PreAuthorize("hasAnyAuthority('USER')")
public class TypeController {
    final
    TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }



    @GetMapping("/")
    public String indexType(Model model){
        Iterable<Type> typeIterable =  typeRepository.findAll();
        model.addAttribute("type_list",typeIterable);
        return "type/index_type";
    }
    @PostMapping("/add")
    public String AddType (@Valid Type type, BindingResult bindingResult) {
        if (type.getTypename().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "type/type-add";
        }

        typeRepository.save(type);
        return "redirect:/type/";
    }
    @GetMapping("/add")
    public String AddView(Type type)
    {
        return "type/type-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="typename") String typename,
            Model model)
    {
        List<Type> typeList = typeRepository.findByTypenameContains(typename);
        model.addAttribute("type_list",typeList);
        return "type/index_type";
    }
    @GetMapping("/detail/{id}")
    public String detailType(
            @PathVariable Long id,
            Model model
    ){
        Type type_obj = typeRepository.findById(id).orElseThrow();
        model.addAttribute("one_type",type_obj);
        return "type/info-type";
    }
    @GetMapping("/detail/{id}/del")
    public String delType(@PathVariable Long id)
    {
        Type type_obj = typeRepository.findById(id).orElseThrow();
        typeRepository.delete(type_obj);
        return "redirect:/type/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Type type,
            Model model
    )
    {
        type= typeRepository.findById(id).orElseThrow();
        model.addAttribute("type",type);
        return "type/update-type";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid Type type, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "type/update-type";
    }

        typeRepository.save(type);

        return "redirect:/type/detail/" + type.getTypeID();
    }


}

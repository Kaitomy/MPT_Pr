package com.example.Proj.controller;


import com.example.Proj.Models.Contractor;
import com.example.Proj.Models.Mark;
import com.example.Proj.Models.Sklad;
import com.example.Proj.Repository.ContractorRepository;
import com.example.Proj.Repository.MarkRepository;
import com.example.Proj.Repository.ModelRepository;
import com.example.Proj.Repository.SkladRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/model")
//@PreAuthorize("hasAnyAuthority('EDITOR')")
@PreAuthorize("hasAnyAuthority('OTHER')")
public class SkladController {
    @Autowired
    public ContractorRepository contractorRepository;
    @Autowired
    public SkladRepository skladRepository;

    @GetMapping("/sklad")
    public String Main(Model model){
        Iterable<Contractor> contractor = contractorRepository.findAll();
        model.addAttribute("contractor",contractor);
        return "sklad/sklad-add";
    }
    @GetMapping("/sklad/info")
    public String indexContrator(Model model){
        Iterable<Sklad> skladIterable =  skladRepository.findAll();
        model.addAttribute("sklad_list",skladIterable);
        return "sklad/index_sklad";
    }
    @PostMapping("/sklad/add")
    public String SkladAdd(@RequestParam String skladname,@RequestParam String skladadress, @RequestParam String skladsity,@RequestParam String skladdesc,@RequestParam String contractorname, Model model)
    {

        Contractor contractorL = contractorRepository.findByContractorname(contractorname);
        Sklad sklad = new Sklad(skladname,skladadress,skladsity,skladdesc, contractorL);
        skladRepository.save(sklad);
        return "redirect:/sklad/info";
    }


    @GetMapping("/sklad/detail/{id}")
    public String detailSklad(
            @PathVariable Long id,
            Model model
    ){
        Sklad sklad_obj = skladRepository.findById(id).orElseThrow();
        model.addAttribute("one_sklad",sklad_obj);
        return "sklad/info-sklad";
    }
    @GetMapping("/sklad/detail/{id}/del")
    public String delSklad(@PathVariable Long id)
    {
        Sklad sklad_obj = skladRepository.findById(id).orElseThrow();
        skladRepository.delete(sklad_obj);
        return "redirect:/sklad/info";
    }
}

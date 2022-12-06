package com.example.Proj.controller;

import com.example.Proj.Models.Contractor;
import com.example.Proj.Models.Mark;
import com.example.Proj.Repository.ContractorRepository;
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
@RequestMapping("/contractor")
//@PreAuthorize("hasAnyAuthority('USER')")
public class ContractorController {
    final
    ContractorRepository contractorRepository;

    public ContractorController(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }



    @GetMapping("/")
    public String indexContractor(Model model){
        Iterable<Contractor> contractorIterable =  contractorRepository.findAll();
        model.addAttribute("contractor_list",contractorIterable);
        return "contractor/index_contractor";
    }
    @PostMapping("/add")
    public String AddContractor (@Valid Contractor contractor, BindingResult bindingResult) {
        if (contractor.getContractorname().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "contractor/contractor-add";
        }

        contractorRepository.save(contractor);
        return "redirect:/contractor/";
    }
    @GetMapping("/add")
    public String AddView(Contractor contractor)
    {
        return "contractor/contractor-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="contractorname") String contractorname,
            Model model)
    {
        List<Contractor> contractorList = contractorRepository.findByContractornameContains(contractorname);
        model.addAttribute("contractor_list",contractorList);
        return "contractor/index_contractor";
    }
    @GetMapping("/detail/{id}")
    public String detailContractor(
            @PathVariable Long id,
            Model model
    ){
        Contractor contractor_obj = contractorRepository.findById(id).orElseThrow();
        model.addAttribute("one_contractor",contractor_obj);
        return "contractor/info-contractor";
    }
    @GetMapping("/detail/{id}/del")
    public String delContractor(@PathVariable Long id)
    {
        Contractor contractor_obj = contractorRepository.findById(id).orElseThrow();
        contractorRepository.delete(contractor_obj);
        return "redirect:/contractor/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            Contractor contractor,
            Model model
    )
    {
        contractor= contractorRepository.findById(id).orElseThrow();
        model.addAttribute("contractor",contractor);
        return "contractor/update-contractor";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid Contractor contractor, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "contractor/update-contractor";
    }

        contractorRepository.save(contractor);

        return "redirect:/contractor/detail/" + contractor.getContractorID();
    }


}


package com.example.Proj.controller;

        import com.example.Proj.Models.Mark;
        import com.example.Proj.Models.ServiceDelivery;
        import com.example.Proj.Repository.MarkRepository;
        import com.example.Proj.Repository.ServiceDeliveryRepository;
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
@RequestMapping("/servicedelivery")
@PreAuthorize("hasAnyAuthority('OTHER')")
//@PreAuthorize("hasAnyAuthority('USER')")
public class ServiceDeliveryController {
    final
    ServiceDeliveryRepository servicedeliveryRepository;

    public ServiceDeliveryController(ServiceDeliveryRepository servicedeliveryRepository) {
        this.servicedeliveryRepository = servicedeliveryRepository;
    }



    @GetMapping("/")
    public String indexServiceDelivery(Model model){
        Iterable<ServiceDelivery> serviceDeliveryIterable =  servicedeliveryRepository.findAll();
        model.addAttribute("service_list",serviceDeliveryIterable);
        return "servicedelivery/index_servicedelivery";
    }
    @PostMapping("/add")
    public String AddServiceDelivery (@Valid ServiceDelivery servicedelivery, BindingResult bindingResult) {
        if (servicedelivery.getServicename().equals("Привет")) {
            bindingResult.addError(new ObjectError("defaultMessage", "Привет! Это дефолтное сообщение"));
        }
        if (bindingResult.hasErrors()) {
            return "servicedelivery/servicedelivery-add";
        }

        servicedeliveryRepository.save(servicedelivery);
        return "redirect:/servicedelivery/";
    }
    @GetMapping("/add")
    public String AddView(ServiceDelivery servicedelivery,Model model)
    {
        model.addAttribute("servicedelivery", servicedelivery);
        return "servicedelivery/servicedelivery-add";
    }


    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="servicename") String servicename,
            Model model)
    {
        List<ServiceDelivery> servicedeliveryList = servicedeliveryRepository.findByServicenameContains(servicename);
        model.addAttribute("service_list",servicedeliveryList);
        return "servicedelivery/index_servicedelivery";
    }
    @GetMapping("/detail/{id}")
    public String detailServiceDelivery(
            @PathVariable Long id,
            Model model
    ){
        ServiceDelivery servicedelivery_obj = servicedeliveryRepository.findById(id).orElseThrow();
        model.addAttribute("one_servicedelivery",servicedelivery_obj);
        return "servicedelivery/info-servicedelivery";
    }
    @GetMapping("/detail/{id}/del")
    public String delServiceDelivery(@PathVariable Long id)
    {
        ServiceDelivery servicedelivery_obj = servicedeliveryRepository.findById(id).orElseThrow();
        servicedeliveryRepository.delete(servicedelivery_obj);
        return "redirect:/servicedelivery/";
    }
    @GetMapping("/detail/{id}/upd")
    public  String updateView(
            @PathVariable Long id,
            ServiceDelivery servicedelivery,
            Model model
    )
    {
        servicedelivery= servicedeliveryRepository.findById(id).orElseThrow();
        model.addAttribute("servicedelivery",servicedelivery);

        return "servicedelivery/update-servicedelivery";
    }
    @PostMapping("/detail/{id}/upd")
    public  String update( @Valid ServiceDelivery servicedelivery, BindingResult bindingResult, Model model)
    { if (bindingResult.hasErrors()) {
        return "servicedelivery/update-servicedelivery";
    }

        servicedeliveryRepository.save(servicedelivery);

        return "redirect:/servicedelivery/detail/" + servicedelivery.getServiceDeliveryID();
    }


}
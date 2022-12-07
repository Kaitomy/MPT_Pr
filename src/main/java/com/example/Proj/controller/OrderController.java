package com.example.Proj.controller;


import com.example.Proj.Models.*;
import com.example.Proj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
//@RequestMapping("/model")
//@PreAuthorize("hasAnyAuthority('EDITOR')")
public class OrderController {
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public TovarRepository tovarRepository;
    @Autowired
    public TypePayRepository typepayRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public AdditionalRepository additionalRepository;

    @GetMapping("/order")
    public String Main(Model model){
        Iterable<Tovar> tovar = tovarRepository.findAll();
        model.addAttribute("tovar",tovar);
        Iterable<TypePay> typepay = typepayRepository.findAll();
        model.addAttribute("typepay",typepay);
        Iterable<User> user = userRepository.findAll();
        model.addAttribute("user",user);
        Iterable<Additional> additional = additionalRepository.findAll();
        model.addAttribute("additional",additional);
        return "order/order-add";
    }
    @GetMapping("/order/info")
    public String indexOrder(Model model){
        Iterable<Order> orderIterable =  orderRepository.findAll();
        model.addAttribute("order_list",orderIterable);
        return "order/index_order";
    }
    @PostMapping("/order/add")
    public String OrderAdd(@RequestParam Date orderdate, @RequestParam String orderaddress, @RequestParam String tovarname, @RequestParam String username, @RequestParam String typepayname, @RequestParam String additionalname, Model model)
    {

        Tovar tovarL = tovarRepository.findByTovarname(tovarname);
        TypePay typepayL = typepayRepository.findByTypepayname(typepayname);
        User userL = userRepository.findByUsername(username);
        Additional additionalL = additionalRepository.findByAdditionalname(additionalname);
        Order order = new Order(orderdate,orderaddress,tovarL,typepayL,additionalL,userL);
        orderRepository.save(order);
        return "redirect:/order/info";
    }


    @GetMapping("/order/detail/{id}")
    public String detailOrder(
            @PathVariable Long id,
            Model model
    ){
        Order order_obj = orderRepository.findById(id).orElseThrow();
        model.addAttribute("one_order",order_obj);
        return "order/info-order";
    }

}

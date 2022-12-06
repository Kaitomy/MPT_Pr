package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class ServiceDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ServiceDeliveryID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  servicename;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  servicecountry;
    @Min(value = 0,message = "Слишком маленькое значение")
    private  Integer  serviceprice;
    @NotBlank(message = "Строка не должна быть пустой")
    private String serviceperiod;
    @OneToMany(mappedBy = "servicedelivery", fetch = FetchType.EAGER)
    private Collection<Tovar> tovar;

    public ServiceDelivery(String servicename,String  servicecountry,Integer  serviceprice,String serviceperiod) {
        this.servicename = servicename;
        this.servicecountry = servicecountry;
        this.serviceprice = serviceprice;
        this.serviceperiod = serviceperiod;

    }

    public ServiceDelivery() {

    }



    public Long getServiceDeliveryID() {
        return ServiceDeliveryID;
    }

    public void setServiceDeliveryID(Long ServiceDeliveryID) {
        this.ServiceDeliveryID = ServiceDeliveryID;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
    public String getServicecountry() {
        return servicecountry;
    }

    public void setServicecountry(String servicecountry) {
        this.servicecountry = servicecountry;
    }
    public Integer getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(Integer serviceprice) {
        this.serviceprice = serviceprice;
    }
    public String getServiceperiod() {
        return serviceperiod;
    }

    public void setServiceperiod(String serviceperiod) {
        this.serviceperiod = serviceperiod;
    }

    public Collection<Tovar> getTovar() {
        return tovar;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }



}
package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Tovar_all")
public class Tovar {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TovarID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String tovarname;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  tovarcolour;
    @Min(value = 100,message = "Слишком маленькое значение")
    private Integer  tovarprice;

    public Tovar(String tovarname, String tovarcolour, Integer tovarprice) {
        this.tovarname = tovarname;
        this.tovarcolour = tovarcolour;
        this.tovarprice = tovarprice;
    }

    @OneToMany(mappedBy = "tovar", fetch = FetchType.EAGER)
    private Collection<Order> order;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Type type;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Sklad sklad;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Model model;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private ServiceDelivery servicedelivery;

    public Tovar() {

    }

    public Integer getTovarprice() {
        return tovarprice;
    }

    public void setTovarprice(Integer tovarprice) {
        this.tovarprice = tovarprice;
    }

    public Long getTovarID() {
        return TovarID;
    }

    public void setTovarID(Long TovarID) {
        this.TovarID = TovarID;
    }

    public String getTovarname() {
        return tovarname;
    }

    public void setTovarname(String tovarname) {
        this.tovarname = tovarname;
    }

    public String getTovarcolour() {
        return tovarcolour;
    }

    public void setTovarcolour(String tovarcolour) {
        this.tovarcolour = tovarcolour;
    }
    public Tovar(String tovarname,String tovarcolour,Integer tovarprice, Type type,Sklad sklad,Model model,ServiceDelivery servicedelivery) {
        this.tovarname = tovarname;
        this.tovarcolour = tovarcolour;
        this.tovarprice = tovarprice;
        this.type = type;
        this.sklad = sklad;
        this.model = model;
        this.servicedelivery = servicedelivery;
    }
    public Collection<Order> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order> order) {
        this.order = order;
    }

}




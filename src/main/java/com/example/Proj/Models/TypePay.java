package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

@Entity
public class TypePay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TypePayID;
    @Column(unique=true)
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  typepayname;
    @Size(min = 1 , max = 50, message = "Строка должна быть от 3 до 50 символов")
    @NotNull()
    private String  typepaycurrency;

    @OneToMany(mappedBy = "typepay", fetch = FetchType.EAGER)
    private Collection<Order> order;
    public TypePay(String typepayname, String typepaycurrency) {
        this.typepayname = typepayname;
        this.typepaycurrency = typepaycurrency;
    }

    public TypePay() {

    }



    public Long getTypePayID() {
        return TypePayID;
    }

    public void setTypePayID(Long TypePayID) {
        this.TypePayID = TypePayID;
    }

    public String getTypepayname() {
        return typepayname;
    }

    public void setTypepayname(String typepayname) {
        this.typepayname = typepayname;
    }

    public String getTypepaycurrency() {
        return typepaycurrency;
    }

    public void setTypepaycurrency(String typepaycurrency) {
        this.typepaycurrency = typepaycurrency;
    }

    public Collection<Order> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order> order) {
        this.order = order;
    }


}

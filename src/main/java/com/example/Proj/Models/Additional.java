package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Additional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AdditionalID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  additionalname;
    @Size(min = 1 , max = 500, message = "Строка должна быть от 1 до 500 символов")
    @NotNull()
    private String  additionaldesc;
    @OneToMany(mappedBy = "additional", fetch = FetchType.EAGER)
    private Collection<Order> order;

    public Additional(String additionalname, String additionaldesc) {
        this.additionalname = additionalname;
        this.additionaldesc = additionaldesc;
    }

    public Additional() {

    }



    public Long getAdditionalID() {
        return AdditionalID;
    }

    public void setAdditionalID(Long AdditionalID) {
        this.AdditionalID = AdditionalID;
    }

    public String getAdditionalname() {
        return additionalname;
    }

    public void setAdditionalname(String additionalname) {
        this.additionalname = additionalname;
    }

    public String getAdditionaldesc() {
        return additionaldesc;
    }

    public void setAdditionaldesc(String additionaldesc) {
        this.additionaldesc = additionaldesc;
    }
    public Collection<Order> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order> order) {
        this.order = order;
    }



}

package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TypeID;
    @Column(unique=true)
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  typename;
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Collection<Tovar> tovar;


    public Type(String typename) {
        this.typename = typename;
    }

    public Type() {

    }



    public Long getTypeID() {
        return TypeID;
    }

    public void setTypeID(Long TypeID) {
        this.TypeID = TypeID;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Collection<Tovar> getTovar() {
        return tovar;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }




}

package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Star {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String name;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  class_star;



    private Integer massStar;
    public Star(String name, String class_star, Integer lumen) {
        this.name = name;
        this.class_star = class_star;
        this.lumen = lumen;
    }
@Min(value = 100,message = "Слишком маленькое значение")
@Max(value = 1000000,message = "Слишком большое значение")
    private Integer lumen;
    @ManyToMany
    @JoinTable(name="astronom_star",
            joinColumns=@JoinColumn(name="star_id"),
            inverseJoinColumns=@JoinColumn(name="astronom_id"))
    private List<Astronom> astronom;
    public Star() {

    }

    public Integer getMassStar() {
        return massStar;
    }

    public void setMassStar(Integer massStar) {
        this.massStar = massStar;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_star() {
        return class_star;
    }

    public void setClass_star(String class_star) {
        this.class_star = class_star;
    }

    public Integer getLumen() {
        return lumen;
    }

    public void setLumen(Integer lumen) {
        this.lumen = lumen;
    }

    public List<Astronom> getAstronom() {
        return astronom;
    }

    public void setAstronom(List<Astronom> astronom) {
        this.astronom = astronom;
    }
}

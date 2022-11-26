package com.example.Proj.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;
import javax.validation.constraints.*;

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
}

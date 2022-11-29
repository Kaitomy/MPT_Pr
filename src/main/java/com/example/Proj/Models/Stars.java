package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "stars_planet")
public class Stars {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StarsID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String name;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  znak;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Constellations constellations;


    public Long getStarsID() {
        return StarsID;
    }

    public void setStarsID(Long StarsID) {
        this.StarsID = StarsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

     public Stars(String name,String znak, Constellations constellations) {
        this.name = name;
         this.znak = name;
        this.constellations = constellations;
    }

    public Stars() {
    }
}

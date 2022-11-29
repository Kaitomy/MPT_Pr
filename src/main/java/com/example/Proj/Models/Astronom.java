package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "astronom_planet")
public class Astronom {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AstronomID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String name;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  country;
    @Min(value = -1000,message = "Слишком малый год")
    @Max(value = 3000,message = "Слишком большой год")
    private Integer  years;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="planet_AstronomID")
    private Planet planet;
    @ManyToMany
    @JoinTable (name="astronom_star",
            joinColumns=@JoinColumn (name="astronom_id"),
            inverseJoinColumns=@JoinColumn(name="star_id"))
    private List<Star> star;

    public Long getAstronomID() {
        return AstronomID;
    }

    public void setAstronomID(Long AstronomID) {
        this.AstronomID = AstronomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Astronom(String name,String country,Integer years, Planet planet) {
        this.name = name;
        this.country = country;
        this.years = years;
        this.planet = planet;
    }

    public Astronom() {
    }
    public List<Star> getStar() {
        return star;
    }

    public void setStar(List<Star> star) {
        this.star = star;
    }
}

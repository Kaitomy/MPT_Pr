package com.example.Proj.Models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Planet {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PlanetID;
    @NotEmpty
    @Size(min = 2 , max = 40, message = "Строка должна быть от 2 до 40 символов")
    private  String planetname;
    @NotEmpty
    @Size(min = 2 , max = 40, message = "Строка должна быть от 2 до 40 символов")
    private String planetsistem;
    @NotEmpty
    @Size(min = 2 , max = 3, message = "Только Да или Нет")
    private String  Planet_Life;
    @Min(value = 100,message = "Слишком малый вес")
    @Max(value = 10000000,message = "Слишком большой вес")
    private Integer Planet_Mass;
    @Positive
    private Integer Planet_Age;
    @OneToOne(optional = true, mappedBy = "planet")
    private Astronom astronom;

    public Planet(String planetname, Integer Planet_Mass, Integer Planet_Age, String planetsistem, String Planet_Life) {
        this.planetname = planetname;
        this.Planet_Mass = Planet_Mass;
        this.Planet_Age = Planet_Age;
        this.planetsistem = planetsistem;
        this.Planet_Life = Planet_Life;
    }


    public Planet() {

    }

    public Long getPlanetID() {
        return PlanetID;
    }

    public void setPlanetID(Long PlanetID) {
        this.PlanetID = PlanetID;
    }

    public String getPlanetname() {
        return planetname;
    }

    public void setPlanetname(String Planet_Name) {
        this.planetname = Planet_Name;
    }

    public Integer getPlanet_Mass() {
        return Planet_Mass;
    }

    public void setPlanet_Mass(Integer Planet_Mass) {
        this.Planet_Mass = Planet_Mass;
    }

    public Integer getPlanet_Age() {
        return Planet_Age;
    }

    public void setPlanet_Age(Integer Planet_Age) {
        this.Planet_Age = Planet_Age;
    }

    public String getPlanetsistem() {
        return planetsistem;
    }

    public void setPlanetsistem(String Planet_Sistem) {
        this.planetsistem = Planet_Sistem;
    }

    public String getPlanet_Life() {
        return Planet_Life;
    }

    public void setPlanet_Life(String Planet_Life) {
        this.Planet_Life = Planet_Life;
    }

    public Astronom getAstronom() {
        return astronom;
    }

    public void setAstronom(Astronom astronom) {
        this.astronom = astronom;
    }
}





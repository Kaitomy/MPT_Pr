package com.example.Proj.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;

@Entity
public class Planet {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PlanetID;

    private  String Planet_Name;

    private String  Planet_Sistem;

    private String  Planet_Life;



    public Planet(String Planet_Name, Integer Planet_Mass, Integer Planet_Age, String Planet_Sistem, String Planet_Life) {
        this.Planet_Name = Planet_Name;
        this.Planet_Mass = Planet_Mass;
        this.Planet_Age = Planet_Age;
        this.Planet_Sistem = Planet_Sistem;
        this.Planet_Life = Planet_Life;
    }

    private Integer Planet_Mass;
    private Integer Planet_Age;

    public Planet() {

    }

    public Long getPlanetID() {
        return PlanetID;
    }

    public void setPlanetID(Long PlanetID) {
        this.PlanetID = PlanetID;
    }

    public String getPlanet_Name() {
        return Planet_Name;
    }

    public void setPlanet_Name(String Planet_Name) {
        this.Planet_Name = Planet_Name;
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

    public String getPlanet_Sistem() {
        return Planet_Sistem;
    }

    public void setPlanet_Sistem(String Planet_Sistem) {
        this.Planet_Sistem = Planet_Sistem;
    }

    public String getPlanet_Life() {
        return Planet_Life;
    }

    public void setPlanet_Life(String Planet_Life) {
        this.Planet_Life = Planet_Life;
    }

}





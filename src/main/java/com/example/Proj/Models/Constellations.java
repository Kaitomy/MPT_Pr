package com.example.Proj.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Constellations {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(strategy = GenerationType.AUTO)
private Long ConstellationsID;

    private  String constellationsname;

    private Integer  Constellations_Number;

    private String  Constellations_Hemisphere;

    private String  Constellations_Season;

    private String  Constellations_Type;




    public Constellations(String constellationsname, Integer Constellations_Number, String Constellations_Hemisphere, String Constellations_Season, String Constellations_Type) {
        this.constellationsname = constellationsname;
        this.Constellations_Number = Constellations_Number;
        this.Constellations_Hemisphere = Constellations_Hemisphere;
        this.Constellations_Season = Constellations_Season;
        this.Constellations_Type = Constellations_Type;
    }


    public Constellations() {

    }

    public Long getConstellationsID() {
        return ConstellationsID;
    }

    public void setConstellationsID(Long ConstellationsID) {
        this.ConstellationsID = ConstellationsID;
    }

    public String getConstellationsname() {
        return constellationsname;
    }

    public void setConstellationsname(String Constellations_Name) {
        this.constellationsname = Constellations_Name;
    }

    public Integer getConstellations_Number() {
        return Constellations_Number;
    }

    public void setConstellations_Number(Integer Constellations_Number) {
        this.Constellations_Number = Constellations_Number;
    }

    public String getConstellations_Hemisphere() {
        return Constellations_Hemisphere;
    }

    public void setConstellations_Hemisphere(String Constellations_Hemisphere) {
        this.Constellations_Hemisphere = Constellations_Hemisphere;
    }

    public String getConstellations_Season() {
        return Constellations_Season;
    }

    public void setConstellations_Season(String Constellations_Season) {
        this.Constellations_Season = Constellations_Season;
    }

    public String getConstellations_Type() {
        return Constellations_Type;
    }

    public void setConstellations_Type(String Constellations_Type) {
        this.Constellations_Type = Constellations_Type;
    }
}



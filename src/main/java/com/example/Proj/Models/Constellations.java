package com.example.Proj.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class Constellations {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(strategy = GenerationType.AUTO)
private Long ConstellationsID;
    @OneToMany(mappedBy = "constellations", fetch = FetchType.EAGER)
    private Collection<Stars> stars;
    @NotEmpty
    @Size(min = 2 , max = 40, message = "Строка должна быть от 2 до 40 символов")
    private  String constellationsname;
    @Min(value = 0,message = "Не может быть меньше 0 звезд")
    @Max(value = 1000,message = "Слишком много звезд")
    private Integer  Constellations_Number;
    @NotEmpty
    @Size(min = 5 , max = 8, message = "Только Северное или Южное")
    private String  Constellations_Hemisphere;
    @NotEmpty
    @Size(min = 1 , max = 25, message = "Ошибка в сезоне")
    private String  Constellations_Season;
    @NotEmpty
    @Size(min = 1 , max = 25, message = "Ошибка в типе созвездия")
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

    public Collection<Stars> getStars() {
        return stars;
    }

    public void setStars(Collection<Stars> stars) {
        this.stars = stars;
    }

}



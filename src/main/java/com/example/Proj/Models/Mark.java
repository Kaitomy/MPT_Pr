package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MarkID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  markname;
    @Size(min = 3 , max = 50, message = "Строка должна быть от 3 до 50 символов")
    @NotNull()
    private String  markccountry;


    public Mark(String markname, String markccountry) {
        this.markname = markname;
        this.markccountry = markccountry;
    }

    public Mark() {

    }



    public Long getMarkID() {
        return MarkID;
    }

    public void setMarkID(Long MarlkID) {
        this.MarkID = MarlkID;
    }

    public String getMarkname() {
        return markname;
    }

    public void setMarkname(String markname) {
        this.markname = markname;
    }

    public String getMarkccountry() {
        return markccountry;
    }

    public void setMarkccountry(String markccountry) {
        this.markccountry = markccountry;
    }




}

package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "sklad_contractor")
public class Sklad {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SkladID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    @Column(unique=true)
    private  String skladname;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  skladadress;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String skladsity;
    @Size(min = 4 , max = 500, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  skladdesc;
    @OneToMany(mappedBy = "sklad", fetch = FetchType.EAGER)
    private Collection<Tovar> tovar;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Contractor contractor;


    public Long getSkladID() {
        return SkladID;
    }

    public void setSkladID(Long SkladID) {
        this.SkladID = SkladID;
    }

    public String getSkladname() {
        return skladname;
    }

    public void setSkladname(String skladname) {
        this.skladname = skladname;
    }

    public String getSkladadress() {
        return skladadress;
    }

    public void setSkladadress(String skladadress) {
        this.skladadress = skladadress;
    }
    public String getSkladsity() {
        return skladsity;
    }

    public void setSkladsity(String skladsity) {
        this.skladsity = skladsity;
    }
    public String getSkladdesc() {
        return skladdesc;
    }

    public void setSkladdesc(String skladdesc) {
        this.skladdesc = skladdesc;
    }
    public Sklad(String skladname,String skladadress,String skladsity,String skladdesc, Contractor contractor) {
        this.skladname = skladname;
        this.skladadress = skladadress;
        this.skladsity = skladsity;
        this.skladdesc = skladdesc;
        this.contractor = contractor;
    }
    public Collection<Tovar> getTovar() {
        return tovar;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }
    public Sklad() {
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
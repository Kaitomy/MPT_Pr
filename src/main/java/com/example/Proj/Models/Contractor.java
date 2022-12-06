package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ContractorID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String  contractorname;
    @NotNull()
    private Date contractordate;
    @Size(min = 1 , max = 500, message = "Строка должна быть от 1 до 500 символов")
    @NotNull()
    private String  contractordesc;
    @OneToMany(mappedBy = "contractor", fetch = FetchType.EAGER)
    private Collection<Sklad> sklad;
    public Contractor(String contractorname, Date contractordate, String contractordesc) {
        this.contractorname = contractorname;
        this.contractordate = contractordate;
        this.contractordesc = contractordesc;
    }

    public Contractor() {

    }



    public Long getContractorID() {
        return ContractorID;
    }

    public void setContractorID(Long ContractorID) {
        this.ContractorID = ContractorID;
    }

    public String getContractorname() {
        return contractorname;
    }

    public void setContractorname(String contractorname) {
        this.contractorname = contractorname;
    }

    public Date getContractordate() {
        return contractordate;
    }

    public void setContractordate(Date contractordate) {
        this.contractordate = contractordate;
    }

    public String getContractordesc() {
        return contractordesc;
    }

    public void setContractordesc(String contractordesc) {
        this.contractordesc = contractordesc;
    }
    public Collection<Sklad> getSklad() {
        return sklad;
    }

    public void setSklad(Collection<Sklad> sklad) {
        this.sklad = sklad;
    }


}

package com.example.Proj.Models;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "model_mark")
public class Model {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ModelID;
    @Size(min = 2 , max = 50, message = "Неверное значение")
    @NotBlank(message = "Строка не должна быть пустой")
    private  String modelname;
    @Size(min = 4 , max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String  modeldesc;
    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER)
    private Collection<Tovar> tovar;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Mark mark;


    public Long getModelID() {
        return ModelID;
    }

    public void setModelID(Long ModelID) {
        this.ModelID = ModelID;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getModeldesc() {
        return modeldesc;
    }

    public void setModeldesc(String modeldesc) {
        this.modeldesc = modeldesc;
    }

    public Model(String modelname,String modeldesc, Mark mark) {
        this.modelname = modelname;
        this.modeldesc = modeldesc;
        this.mark = mark;
    }
    public Collection<Tovar> getTovar() {
        return tovar;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }
    public Model() {
    }
}

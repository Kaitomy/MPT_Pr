package com.example.Proj.Repository;

import com.example.Proj.Models.Model;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model,Long> {
    Model findByModelname(String modelname);
}

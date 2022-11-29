package com.example.Proj.Repository;

import com.example.Proj.Models.Astronom;
import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Stars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AstronomRepository extends CrudRepository<Astronom,Long> {
    Astronom findByName(String name);
}
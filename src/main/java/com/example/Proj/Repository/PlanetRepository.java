package com.example.Proj.Repository;

import com.example.Proj.Models.Planet;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PlanetRepository extends CrudRepository<Planet,Long> {
   //Iterable<Planet> findByNamePlanet(String Planet_Name);

}

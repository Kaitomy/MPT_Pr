package com.example.Proj.Repository;

import com.example.Proj.Models.Planet;
import com.example.Proj.Models.Star;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PlanetRepository extends CrudRepository<Planet,Long> {
    //Planet_Name
   public List<Planet> findByPlanetname(String planet_name);

    public List<Planet> findByPlanetnameContains(String planet_name);

}

package com.example.Proj.Repository;

import com.example.Proj.Models.Constellations;
import com.example.Proj.Models.Planet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConstellationsRepository extends CrudRepository<Constellations,Long> {
  // public List<Constellations> findByConstellationsname(String constellations_name);
    Constellations findByConstellationsname(String constellations_name);
    public List<Constellations> findByConstellationsnameContains(String constellations_name);
}

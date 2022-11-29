package com.example.Proj.Repository;

import com.example.Proj.Models.Astronom;
import com.example.Proj.Models.Star;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StarRepository extends CrudRepository<Star,Long> {
//public List<Star> findByName(String name);
    Star findByName(String name);
public List<Star> findByNameContains(String name);
}

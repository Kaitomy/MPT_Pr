package com.example.Proj.Repository;

import com.example.Proj.Models.Sklad;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

public interface SkladRepository extends CrudRepository<Sklad,Long> {
    Sklad findBySkladname(String skladname);
}

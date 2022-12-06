package com.example.Proj.Repository;

import com.example.Proj.Models.Additional;
import com.example.Proj.Models.Mark;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdditionalRepository extends CrudRepository<Additional,Long> {
    Additional findByAdditionalname(String additionalname);

    public List<Additional> findByAdditionalnameContains(String additionalname);
}

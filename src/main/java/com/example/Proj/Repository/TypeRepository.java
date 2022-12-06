package com.example.Proj.Repository;

import com.example.Proj.Models.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type,Long> {
    Type findByTypename(String typename);
}

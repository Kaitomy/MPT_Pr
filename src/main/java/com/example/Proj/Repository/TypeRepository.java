package com.example.Proj.Repository;

import com.example.Proj.Models.Additional;
import com.example.Proj.Models.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type,Long> {
    Type findByTypename(String typename);
    public List<Type> findByTypenameContains(String typename);
}

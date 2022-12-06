package com.example.Proj.Repository;

import com.example.Proj.Models.Mark;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark,Long> {
    Mark findByMarkname(String markname);
}

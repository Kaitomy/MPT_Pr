package com.example.Proj.Repository;

import com.example.Proj.Models.Tovar;
import com.example.Proj.Models.TypePay;
import org.springframework.data.repository.CrudRepository;

public interface TovarRepository extends CrudRepository<Tovar,Long> {
    Tovar findByTovarname(String tovarname);
}

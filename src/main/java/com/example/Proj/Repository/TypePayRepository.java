package com.example.Proj.Repository;

import com.example.Proj.Models.Type;
import com.example.Proj.Models.TypePay;
import org.springframework.data.repository.CrudRepository;

public interface TypePayRepository extends CrudRepository<TypePay,Long> {
    TypePay findByTypepayname(String typepayname);
}

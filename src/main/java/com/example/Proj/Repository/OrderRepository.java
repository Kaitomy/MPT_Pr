package com.example.Proj.Repository;

import com.example.Proj.Models.Order;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {

}

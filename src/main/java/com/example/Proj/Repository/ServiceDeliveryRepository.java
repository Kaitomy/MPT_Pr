package com.example.Proj.Repository;

import com.example.Proj.Models.Mark;
import com.example.Proj.Models.ServiceDelivery;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceDeliveryRepository extends CrudRepository<ServiceDelivery,Long> {
    ServiceDelivery findByServicename(String servicename);

    public List<ServiceDelivery> findByServicenameContains(String servicename);
}

package com.example.Proj.Repository;

import com.example.Proj.Models.ServiceDelivery;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

public interface ServiceDeliveryRepository extends CrudRepository<ServiceDelivery,Long> {
    ServiceDelivery findByServicename(String servicename);
}

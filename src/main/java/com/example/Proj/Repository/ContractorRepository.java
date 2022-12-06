package com.example.Proj.Repository;

import com.example.Proj.Models.Contractor;
import com.example.Proj.Models.Mark;
import com.example.Proj.Models.Tovar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractorRepository extends CrudRepository<Contractor,Long> {
    Contractor findByContractorname(String contractorname);

    public List<Contractor> findByContractornameContains(String contractorname);
}

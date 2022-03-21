package com.practicaIBM.Proiect_practicaIBM.repository;

import com.practicaIBM.Proiect_practicaIBM.model.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends CrudRepository<Garage,Integer> {
}

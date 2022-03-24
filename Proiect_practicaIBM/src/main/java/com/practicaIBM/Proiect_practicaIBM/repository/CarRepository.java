package com.practicaIBM.Proiect_practicaIBM.repository;

import com.practicaIBM.Proiect_practicaIBM.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {


}

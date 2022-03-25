package com.practicaIBM.Proiect_practicaIBM.repository;

import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {


}

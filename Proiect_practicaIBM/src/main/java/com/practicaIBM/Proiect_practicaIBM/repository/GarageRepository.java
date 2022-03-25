package com.practicaIBM.Proiect_practicaIBM.repository;

import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage,Integer> {
}

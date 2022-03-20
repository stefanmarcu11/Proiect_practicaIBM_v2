package com.practicaIBM.Proiect_practicaIBM.service;

import com.practicaIBM.Proiect_practicaIBM.model.Cars;
import com.practicaIBM.Proiect_practicaIBM.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    CarsRepository carsRepository;

    public List<Cars> getcarsList() {

        return (List<Cars>) carsRepository.findAll();
    }


    public void save(Cars car) {
        carsRepository.save(car);

    }
    public void delete(Cars car){

        carsRepository.delete(car);
    }

    public Cars findcarById(Cars car){

        return carsRepository.findById(car.getId()).get();
    }
    public Optional<Cars> findById(int id) {

        return carsRepository.findById(id);
    }

}




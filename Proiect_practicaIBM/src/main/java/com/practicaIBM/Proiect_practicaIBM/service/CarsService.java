package com.practicaIBM.Proiect_practicaIBM.service;

import com.practicaIBM.Proiect_practicaIBM.model.Car;
import com.practicaIBM.Proiect_practicaIBM.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    CarRepository carsRepository;

    public List<Car> getcarsList() {

        return (List<Car>) carsRepository.findAll();
    }

    public void save(Car car) {
        carsRepository.save(car);

    }
    public void deleteById(int id){

        carsRepository.deleteById(id);
    }

    public Car findcarById(Car car){

        return carsRepository.findById(car.getId()).get();
    }
    public Optional<Car> findById(int id) {

        return carsRepository.findById(id);
    }

}




package com.practicaIBM.Proiect_practicaIBM.service;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import com.practicaIBM.Proiect_practicaIBM.mapper.CarMapper;
import com.practicaIBM.Proiect_practicaIBM.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsService {

    @Autowired
    CarRepository carsRepository;

    @Autowired
    CarMapper mapper;

    public List<CarDto> getcarsList() {

        return carsRepository.findAll().stream().map(c ->mapper.mapCarDto(c)).collect(Collectors.toList());
        //(List<Car>) carsRepository.findAll();
    }

    public void save(CarDto carDto) {
        Car car = mapper.mapCar(carDto);
        carsRepository.save(car);

    }
    public void deleteById(int id){

        carsRepository.deleteById(id);
    }

    public CarDto findcarById(int id){
        Car car = carsRepository.findById(id).get();
        return mapper.mapCarDto(car);
    }
    public Optional<Car> findById(int id) {

        return carsRepository.findById(id);
    }

}






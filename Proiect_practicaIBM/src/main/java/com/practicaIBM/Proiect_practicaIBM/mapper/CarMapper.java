package com.practicaIBM.Proiect_practicaIBM.mapper;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto mapCarDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setRegnumber(car.getRegnumber());
        carDto.setCarbrand(car.getCarbrand());
        carDto.setModel(car.getModel());
        carDto.setPower(car.getPower());
        carDto.setType(car.getType());
        carDto.setYear(car.getYear());
        carDto.setConsumption(car.getConsumption());

        return carDto;
    }

    public Car mapCar(CarDto carDto){
        Car car = new Car();
        car.setId(carDto.getId());
        car.setRegnumber(carDto.getRegnumber());
        car.setCarbrand(carDto.getCarbrand());
        car.setModel(carDto.getModel());
        car.setPower(carDto.getPower());
        car.setType(carDto.getType());
        car.setYear(carDto.getYear());
        car.setConsumption(carDto.getConsumption());
        return car;
    }
}

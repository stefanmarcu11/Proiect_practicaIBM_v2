package com.practicaIBM.Proiect_practicaIBM.mapper;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto mapCarDto(Car car){
        GarageDto garageDto = GarageDto.builder()
                .id(car.getGarage().getId())
                .address(car.getGarage().getAddress())
                .phone(car.getGarage().getPhone())
                .nr_cars(car.getGarage().getNr_cars()).build();

        return CarDto.builder()
                .id(car.getId())
                .regnumber(car.getRegnumber())
                .carbrand(car.getCarbrand())
                .model(car.getModel())
                .power(car.getPower())
                .year(car.getYear())
                .consumption(car.getConsumption())
                .garage(garageDto)
                .build();


    }

    public Car mapCar(CarDto carDto){
        return Car.builder()
                .id(carDto.getId())
                .regnumber(carDto.getRegnumber())
                .carbrand(carDto.getCarbrand())
                .model(carDto.getModel())
                .power(carDto.getPower())
                .type(carDto.getType())
                .year(carDto.getYear())
                .consumption(carDto.getConsumption())
                .build();
    }
}

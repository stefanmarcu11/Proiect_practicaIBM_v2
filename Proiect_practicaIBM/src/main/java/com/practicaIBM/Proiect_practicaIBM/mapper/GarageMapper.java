package com.practicaIBM.Proiect_practicaIBM.mapper;

import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import org.springframework.stereotype.Component;

@Component
public class GarageMapper {

    public GarageDto mapGarageDto(Garage garage){
        GarageDto garageDto = new GarageDto();
        garageDto.setId(garage.getId());
        garageDto.setAddress(garage.getAddress());
        garageDto.setPhone(garage.getPhone());
        garageDto.setNr_cars(garage.getNr_cars());
        return garageDto;
    }

    public Garage mapGarage(GarageDto garageDto){
        Garage garage = new Garage();
        garage.setId(garageDto.getId());
        garage.setAddress(garageDto.getAddress());
        garage.setPhone(garageDto.getPhone());
        garage.setNr_cars(garageDto.getNr_cars());
        return garage;
    }

}

package com.practicaIBM.Proiect_practicaIBM.service;

import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import com.practicaIBM.Proiect_practicaIBM.mapper.GarageMapper;
import com.practicaIBM.Proiect_practicaIBM.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarageService {

    @Autowired
    GarageRepository garageRepository;

    @Autowired
    GarageMapper mapper;

    public List<GarageDto> getGarageList() {

        return garageRepository.findAll().stream()
                .map(g ->mapper.mapGarageDto(g))
                .collect(Collectors.toList());

    }
    public void save(GarageDto garageDto) {
        Garage garage = mapper.mapGarage(garageDto);
        garageRepository.save(garage);

    }
    public void deleteById(int id){

        garageRepository.deleteById(id);
    }

    public GarageDto findgarageById(int id){
        Garage garage = garageRepository.findById(id).get();
        return mapper.mapGarageDto(garage);
    }
    public Optional<Garage> findById(int id) {

        return garageRepository.findById(id);
    }

}

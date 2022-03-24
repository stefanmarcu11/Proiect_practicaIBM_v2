package com.practicaIBM.Proiect_practicaIBM.service;

import com.practicaIBM.Proiect_practicaIBM.model.Garage;
import com.practicaIBM.Proiect_practicaIBM.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    @Autowired
    GarageRepository garageRepository;

    public List<Garage> getGarageList() {

        return (List<Garage>) garageRepository.findAll();
    }
    public void save(Garage garage) {
        garageRepository.save(garage);

    }
    public void deleteById(int id){

        garageRepository.deleteById(id);
    }

    public Garage findgarageById(Garage garage){

        return garageRepository.findById(garage.getId()).get();
    }
    public Optional<Garage> findById(int id) {

        return garageRepository.findById(id);
    }
}

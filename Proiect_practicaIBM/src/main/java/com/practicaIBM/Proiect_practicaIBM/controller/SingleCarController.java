package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import com.practicaIBM.Proiect_practicaIBM.mapper.GarageMapper;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import com.practicaIBM.Proiect_practicaIBM.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/cars/{id}")
public class SingleCarController {

    @Autowired
    CarsService carsService;

    @Autowired
    GarageService garageService;

    @ModelAttribute("carId")
    protected Car modelCar(@PathVariable int id){
        Optional<Car> carOpt = carsService.findById(id);
        if(carOpt.isPresent()) {
            return carOpt.get();
        } else {
            throw new NotFoundException(Car.class,id);
        }
    }
    @GetMapping
    public String editSingleCar() {

        return "SingleCarEdit";
    }

    @PostMapping
    public String save(@Validated CarDto car, BindingResult result, Locale locale) {
        if (result.hasErrors()) {
            return "SingleCarEdit";
        }
        try {
            GarageMapper garageMapper = new GarageMapper();
            car.setGarage(garageService.findgarageById(car.getGarage().getId()));
            carsService.save(car);
            return "redirect:/cars";
        } catch (Exception e ) {
            System.out.println(e);
            return "redirect:/cars/{id}";
        }
    }

}

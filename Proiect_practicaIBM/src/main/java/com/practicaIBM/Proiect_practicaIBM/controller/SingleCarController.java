package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.model.Car;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/cars/{id}")
@RequiredArgsConstructor
public class SingleCarController {

    private final CarsService carsService;

    @ModelAttribute("carId")
    protected Car modelPerson(@PathVariable int id){
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
    public String save(@Validated Car car, BindingResult result, Locale locale) {
        if (result.hasErrors()) {
            return "SingleCarEdit";
        }
        try {
            carsService.save(car);
            return "redirect:/cars";
        } catch (Exception e ) {
            return "redirect:/edit";
        }
    }

}

package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.model.Cars;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cars/{id}")
@RequiredArgsConstructor
public class SingleCarController {

    private final CarsService carsService;
    private final MessageSource messageSource;


    @ModelAttribute("carId")
    protected Cars modelPerson(@PathVariable int id){
        Optional<Cars> carOpt = carsService.findById(id);
        if(carOpt.isPresent()) {
            return carOpt.get();
        } else {
            throw new NotFoundException(Cars.class,id);
        }
    }
    @GetMapping
    public String showSingleCar(){

        return "SingleCarShow";
    }

}

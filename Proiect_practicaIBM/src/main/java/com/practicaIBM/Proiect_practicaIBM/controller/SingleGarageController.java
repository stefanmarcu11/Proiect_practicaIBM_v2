package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import com.practicaIBM.Proiect_practicaIBM.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/garageshow/{id}")
@RequiredArgsConstructor
public class SingleGarageController {

    private final GarageService garageService;

    @ModelAttribute("garageId")
    protected Garage modelGarage(@PathVariable int id){
        Optional<Garage> garageOpt = garageService.findById(id);
        if(garageOpt.isPresent()) {
            return garageOpt.get();
        } else {
            throw new NotFoundException(Garage.class,id);
        }
    }
    @GetMapping
    public String editSingleCar() {

        return "SingleGarageEdit";
    }

    @PostMapping
    public String save(@Validated GarageDto garage, BindingResult result, Locale locale) {
        if (result.hasErrors()) {
            return "SingleGarageEdit";
        }
        try {
            garageService.save(garage);
            return "redirect:/garageshow";
        } catch (Exception e ) {
            return "redirect:/garageshow/{id}";
        }
    }
}

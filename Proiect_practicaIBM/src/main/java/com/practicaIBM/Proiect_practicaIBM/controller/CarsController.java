package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.model.Cars;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CarsController {

    @Autowired
    CarsService service;

    @GetMapping(value="/cars")
    public String getValue(Model model){
        model.addAttribute("carsList",service.getcarsList());
        return "ListCars";
    }

    @GetMapping(value="/addcar")
    public String addCar(Model model){
        Cars car=new Cars();
        model.addAttribute("cars",car);
        return "AddDataCar";
    }
    @PostMapping(value = "/submitCar")
    public String submitCar(@ModelAttribute Cars cars){
        service.save(cars);
        return "redirect:/cars";
    }



}

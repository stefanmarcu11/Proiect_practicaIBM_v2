package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.model.Car;
import com.practicaIBM.Proiect_practicaIBM.model.Garage;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CarController {

    @Autowired
    CarsService service;

    @GetMapping(value="/cars")
    public String getValue(Model model){
        model.addAttribute("carsList",service.getcarsList());
        return "ListCars";
    }

    @GetMapping(value="/addcar")
    public String addCar(Model model){
        Car car=new Car();
        model.addAttribute("cars",car);
        return "AddDataCar";
    }

    @PostMapping(value = "/submitCar")
    public String submitCar(@ModelAttribute Car cars){
        service.save(cars);
        return "redirect:/cars";
    }

    @PostMapping(value="/deleteCar")
    public String deleteCar(@RequestParam("carId") int id){
        service.deleteById(id);
        return"redirect:/cars";
    }
}

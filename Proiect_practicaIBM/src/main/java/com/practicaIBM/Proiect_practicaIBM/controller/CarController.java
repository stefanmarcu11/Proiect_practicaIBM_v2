package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    @Autowired
    CarsService service;

    @GetMapping(value="/cars")
    public String getValue(Model model){
        List<CarDto> carDtoList = service.getcarsList();
        model.addAttribute("carsList",carDtoList);
        return "ListCars";
    }

    @GetMapping(value="/addcar")
    public String addCar(Model model){
        CarDto car=new CarDto();
        model.addAttribute("cars",car);
        return "AddDataCar";
    }

    @PostMapping(value = "/submitCar")
    public String submitCar(@ModelAttribute CarDto carsDto){
        service.save(carsDto);
        return "redirect:/cars";
    }

    @PostMapping(value="/deleteCar")
    public String deleteCar(@RequestParam("carId") int id){
        service.deleteById(id);
        return"redirect:/cars";
    }
}

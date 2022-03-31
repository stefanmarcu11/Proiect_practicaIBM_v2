package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.dto.CarDto;
import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Car;
import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import com.practicaIBM.Proiect_practicaIBM.exception.NotFoundException;
import com.practicaIBM.Proiect_practicaIBM.service.CarsService;
import com.practicaIBM.Proiect_practicaIBM.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CarController {

    @Autowired
    CarsService service;

    @Autowired
    GarageService garageService;

    @GetMapping(value="/cars")
    public String getValue(Model model){
        List<CarDto> carDtoList = service.getcarsList();
        model.addAttribute("carsList",carDtoList);
        return "ListCars";
    }

    @GetMapping(value="/addcar")
    public String addCar(Model model){
        List<GarageDto> garageList = garageService.getGarageList();
        model.addAttribute("garageList",garageList);
        CarDto car=new CarDto();
        model.addAttribute("cars",car);
        return "AddDataCar";
    }

    @PostMapping(value = "/submitCar")
    public String submitCar(@ModelAttribute CarDto carsDto){
        System.out.println(carsDto.getGarage());
        service.save(carsDto);
        return "redirect:/cars";
    }

    @PostMapping(value="/deleteCar")
    public String deleteCar(@RequestParam("carId") int id){
        service.deleteById(id);
        return"redirect:/cars";
    }
}

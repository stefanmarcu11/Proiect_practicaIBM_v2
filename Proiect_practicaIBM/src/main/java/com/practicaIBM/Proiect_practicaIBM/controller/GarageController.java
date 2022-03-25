package com.practicaIBM.Proiect_practicaIBM.controller;

import com.practicaIBM.Proiect_practicaIBM.dto.GarageDto;
import com.practicaIBM.Proiect_practicaIBM.entity.Garage;
import com.practicaIBM.Proiect_practicaIBM.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GarageController {

    @Autowired
    GarageService garageService;

    @GetMapping(value="/garageshow")
    public String getValue(Model model){
        List<GarageDto> garageDtoList = garageService.getGarageList();
        model.addAttribute("garageList",garageDtoList);
        return "ListGarages";
    }
    @GetMapping(value="/addgarage")
    public String addCar(Model model){
        GarageDto garage=new GarageDto();
        model.addAttribute("garage",garage);
        return "AddDataGarage";
    }
    @PostMapping(value = "/submitGarage")
    //@RequestMapping(value="/submitGarage",method = {RequestMethod.POST,RequestMethod.GET})
    public String submitCar(@ModelAttribute GarageDto garage){
        garageService.save(garage);
        return "redirect:/garageshow";
    }

    @PostMapping(value="/deleteGarage")
    public String deleteGarage(@RequestParam("garageId") int id){
        garageService.deleteById(id);
        return"redirect:/garageshow";
    }


}

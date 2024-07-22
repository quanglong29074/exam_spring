package com.example.exam_spring.controller;

import com.example.exam_spring.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("vehicles")
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicles/vehicle-list";
    }
}

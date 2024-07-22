package com.example.exam_spring.controller;

import com.example.exam_spring.entity.Vehicle;
import com.example.exam_spring.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicles/vehicle-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/vehicle-form";
    }

    @PostMapping("/add")
    public String addVehicle(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return "vehicles/vehicle-form";
        }
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle Id:" + id));
        model.addAttribute("vehicle", vehicle);
        return "vehicles/vehicle-form";
    }

    @PostMapping("/edit/{id}")
    public String updateVehicle(@PathVariable("id") int id, @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return "vehicles/vehicle-form";
        }
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int id) {
        vehicleService.deleteById(id);
        return "redirect:/vehicles";
    }
}

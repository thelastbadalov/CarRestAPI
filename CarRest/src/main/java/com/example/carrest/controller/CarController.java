package com.example.carrest.controller;

import com.example.carrest.model.Car;
import com.example.carrest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

private final CarService carService;

@GetMapping
public List<Car> getAll(){
   return carService.getAllCars();
}


@PostMapping("/new")
    public void insert(@RequestBody Car car){
    carService.insert(car);
}
@DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable long id){
    carService.deleteCar(id);
}
@PutMapping("/edit/{id}")
    public Car update(@RequestBody Car car,@PathVariable long id){
   return carService.update(car,id);
}
}

package com.example.carrest.service;

import com.example.carrest.model.Car;
import com.example.carrest.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
private final CarRepository carRepository;

    public List<Car> getAllCars() {

   return carRepository.findAll();
    }

    public void insert(Car car) {
    carRepository.save(car);
    }

    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    public Car update(Car car, long id) {
Optional<Car> car1=carRepository.findById(id);
if(car1.isPresent()){
    Car newCar=car1.get();
newCar.setModel(car.getModel());
newCar.setId(car.getId());
newCar.setHorsePower(car.getHorsePower());

return carRepository.save(newCar);
}
return null;
    }
}

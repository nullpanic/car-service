package com.red.carsales.controller;

import com.red.carsales.carService.CarService;
import com.red.carsales.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id) {

        return ResponseEntity.ok(carService.getCar(id));
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllAvCars());
    }

    @PostMapping(value = "/car", consumes = {"application/json"})
    public ResponseEntity<CarDto> addNewCar(@RequestBody CarDto carDto) {

        carService.createCar(carDto);

        return ResponseEntity.ok(carDto);

    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @RequestBody CarDto carDtoUpdate) {
        carService.updateCar(id, carDtoUpdate);
        return ResponseEntity.ok(carDtoUpdate);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Car with id " + id + " deleted!");
    }

}

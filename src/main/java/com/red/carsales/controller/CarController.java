package com.red.carsales.controller;

import com.red.carsales.carService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarService carService;

}

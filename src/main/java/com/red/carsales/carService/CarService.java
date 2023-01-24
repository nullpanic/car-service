package com.red.carsales.carService;

import com.red.carsales.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllAvCars();

    CarDto getCar(Long id);

    void createCar(CarDto carDto);

    void deleteCar(Long id);

    void updateCar(Long id, CarDto carDto);

}

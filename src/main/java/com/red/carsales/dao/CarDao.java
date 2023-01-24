package com.red.carsales.dao;

import com.red.carsales.entity.Car;

import java.util.List;

public interface CarDao {

    List<Car> getAllCars();

    void deleteCar(Long id);

    Car getCarById(Long id);

    void save(Car car);
}

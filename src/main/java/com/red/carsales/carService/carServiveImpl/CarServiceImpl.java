package com.red.carsales.carService.carServiveImpl;

import com.red.carsales.carService.CarService;
import com.red.carsales.dao.CarDao;
import com.red.carsales.dto.CarDto;
import com.red.carsales.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<CarDto> getAllAvCars() {

        List<CarDto> carDtos = new ArrayList<>();

        carDao.getAllCars().forEach(car -> carDtos.add(new CarDto(car)));

        return carDtos;
    }

    @Override
    public CarDto getCar(Long id) {

        CarDto carDto = new CarDto(carDao.getCarById(id));

        return carDto;
    }

    @Override
    @Transactional
    public void createCar(CarDto carDto) {

        Car car = new Car();

        car.setName(carDto.getName());
        car.setDescription(carDto.getDescription());
        car.setPhoto(carDto.getPhoto());
        car.setPrice(carDto.getPrice());

        carDao.save(car);
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        carDao.deleteCar(id);
    }

    @Override
    @Transactional
    public void updateCar(Long id, CarDto carDto) {

        Car car = carDao.getCarById(id);

        car.setName(carDto.getName());
        car.setDescription(carDto.getDescription());
        car.setPhoto(carDto.getPhoto());
        car.setPrice(carDto.getPrice());

        carDao.save(car);

    }
}

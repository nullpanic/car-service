package com.red.carsales.dto;

import com.red.carsales.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDto {

    private Long id;

    private String model;

    private String description;

    private byte[] photo;

    private int price;

    public CarDto(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.description = car.getDescription();
        this.photo = car.getPhoto();
        this.price = car.getPrice();
    }

}

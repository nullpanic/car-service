package com.red.carsales.dto;

import com.red.carsales.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
public class CarDto {

    private String name;

    private String description;

    private byte[] photo;

    private int price;

    public CarDto(Car car) {
        this.name = car.getName();
        this.description = car.getDescription();
        this.photo = car.getPhoto();
        this.price = car.getPrice();
    }

}

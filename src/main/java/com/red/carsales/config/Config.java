package com.red.carsales.config;

import com.red.carsales.carService.CarService;
import com.red.carsales.carService.carServiveImpl.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.red.carsales")
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CarService carService() {
        return new CarServiceImpl();
    }

}

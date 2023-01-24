package com.red.carsales.dao;

import com.red.carsales.entity.Car;
import com.red.carsales.exception.CarNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAllCars() {

        Session session = sessionFactory.getCurrentSession();

        List<Car> cars = session.createQuery("from Car", Car.class).getResultList();

        return cars;
    }

    @Override
    public void deleteCar(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Car where id=:carId");

        query.setParameter("carId", id);

        int number = query.executeUpdate();

        if (number == 0) throw new CarNotFoundException("No car with id " + id);

    }

    @Override
    public Car getCarById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Car car = session.get(Car.class, id);

        if (car == null) throw new CarNotFoundException("No car with id " + id);

        return car;
    }

    @Override
    public void save(Car car) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(car);
    }
}

package com.raj.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.bean.Car;
import com.raj.dao.CarDao;
import com.raj.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;

	public void create(Car car) {
		carDao.create(car);
	}

	public void update(Car car) {
		carDao.update(car);
	}

	public void delete(Car car) {
		carDao.delete(car);
	}

	public List<Car> findAll() {
		return carDao.findAll();
	}

	public Car find(Car car) {
		return carDao.find(car);
	}

	public void deleteAll() {
		carDao.deleteAll();
	}
}
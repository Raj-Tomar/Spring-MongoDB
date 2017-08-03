package com.raj.service;

import java.util.List;

import com.raj.bean.Car;

public interface CarService {

	public void create(Car car);

	public void update(Car car);

	public void delete(Car car);

	public void deleteAll();

	public Car find(Car car);

	public List<Car> findAll();
}
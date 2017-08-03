package com.raj.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.bean.Car;
import com.raj.service.CarService;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService carService; 
    private static Logger logger = Logger.getLogger(CarController.class);
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test", HttpStatus.OK);
	}
	
	
	 //-------------------Retrieve All Cars--------------------------------------------------------
    
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> listAllCars() {
    	List<Car> cars = carService.findAll();
    	logger.info("Total Car : " + cars.size());
    	if(cars.isEmpty()){
    		return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    	}
    	return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }
 
}

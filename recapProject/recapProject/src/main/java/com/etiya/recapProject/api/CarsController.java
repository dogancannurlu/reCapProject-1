package com.etiya.recapProject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.recapProject.business.abstracts.CarService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.dtos.CarDetailDto;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarsController {

	CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Car>> getAll() {
		return this.carService.getAll();
	}

	@PostMapping("addCar")
	public Result add(@RequestBody Car car) {
		return this.carService.add(car);
	}

	@PostMapping("updateCar")
	public Result update(Car car) {
		return this.carService.update(car);
	}

	@PutMapping("deleteCar")
	public Result delete(Car car) {
		return this.carService.delete(car);
	}
	@GetMapping("getCarById")
	public DataResult<Car> getById(int id){
		return this.carService.getById(id);
	}

	@GetMapping("getCarDetailDto")
	public DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetails() {

		return this.carService.getCarWithBrandAndColorDetails();
	}

}

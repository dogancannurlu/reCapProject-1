package com.etiya.recapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.dtos.CarDetailDto;



public interface CarDao extends JpaRepository<Car, Integer> {

	@Query("Select new com.etiya.recapProject.entities.dtos.CarDetailDto"
			+ " (c.carName, b.brandName , col.colorName, c.dailyPrice) " 
			+ " From Car c Inner Join c.brand b"
			+ " Inner Join c.color col")
	List<CarDetailDto> getCarWithBrandAndColorDetails();

}

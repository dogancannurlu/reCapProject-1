package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.dtos.CarDetailDto;

public interface CarService extends CrudService<Car> {

	DataResult<Car> getById(int id);

	DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetails();

}

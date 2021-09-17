package com.etiya.recapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.CarService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.core.utilities.SuccessDataResult;
import com.etiya.recapProject.core.utilities.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.CarDao;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.dtos.CarDetailDto;

@Service
public class CarManager implements CarService {
	CarDao carDao;

	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public Result add(Car entity) {
		this.carDao.save(entity);
		return new SuccessResult("Araba eklendi.");
	}

	@Override
	public Result update(Car entity) {
		this.carDao.save(entity);
		return new SuccessResult("Araba güncellendi.");

	}

	@Override
	public Result delete(Car entity) {
		this.carDao.delete(entity);
		return new SuccessResult("Araba silindi.");

	}

	@Override
	public DataResult<List<Car>> getAll() {

		return new SuccessDataResult<List<Car>>(this.carDao.findAll(), "Arabalar listelendi.");
	}

	@Override
	public DataResult<Car> getById(int id) {

		return new SuccessDataResult<Car>(this.carDao.findById(id).get(), "Id'ye göre araban getirildi.");
	}

	@Override
	public DataResult<List<CarDetailDto>> getCarWithBrandAndColorDetails() {

		return new SuccessDataResult<List<CarDetailDto>>(this.carDao.getCarWithBrandAndColorDetails(),"Detail getirildi.");
	}

}

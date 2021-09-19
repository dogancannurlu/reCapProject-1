package com.etiya.recapProject.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.CarService;
import com.etiya.recapProject.business.constants.Messages;
import com.etiya.recapProject.core.business.İmagePaths;
import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.core.utilities.results.SuccessDataResult;
import com.etiya.recapProject.core.utilities.results.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.CarDao;
import com.etiya.recapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.recapProject.entities.concretes.Brand;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.concretes.CarImage;
import com.etiya.recapProject.entities.concretes.Color;
import com.etiya.recapProject.entities.dtos.CarDetailDto;
import com.etiya.recapProject.entities.requests.createRequests.CreateCarRequest;
import com.etiya.recapProject.entities.requests.deleteRequests.DeleteCarRequest;
import com.etiya.recapProject.entities.requests.updateRequests.UpdateCarRequest;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private CarImageDao carImageDao;

	@Autowired
	public CarManager(CarDao carDao, CarImageDao carImageDao) {
		super();
		this.carDao = carDao;
		this.carImageDao = carImageDao;
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {

		Brand brand = new Brand();
		brand.setId(createCarRequest.getBrandId());

		Color color = new Color();
		color.setId(createCarRequest.getColorId());

		Car car = new Car();
		car.setCarName(createCarRequest.getCarName());
		car.setDailyPrice(createCarRequest.getDailyPrice());
		car.setDescription(createCarRequest.getDescription());
		car.setModelYear(createCarRequest.getModelYear());
		car.setBrand(brand);
		car.setColor(color);

		CarImage carImage = new CarImage();
		carImage.setImagePath(İmagePaths.CARDEFAULTIMAGEPATH);
		carImage.setCar(car);
		carImage.setDate(LocalDate.now());
		carImageDao.save(carImage);

		this.carDao.save(car);
		return new SuccessResult(Messages.CARADD);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Brand brand = new Brand();
		brand.setId(updateCarRequest.getBrandId());

		Color color = new Color();
		color.setId(updateCarRequest.getColorId());

		Car car = new Car();
		car.setCarName(updateCarRequest.getCarName());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setDescription(updateCarRequest.getDescription());
		car.setModelYear(updateCarRequest.getModelYear());
		car.setBrand(brand);
		car.setColor(color);

		this.carDao.save(car);
		return new SuccessResult(Messages.CARUPDATE);
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Car car = new Car();
		car.setId(this.carDao.getByCarName(deleteCarRequest.getCarName()).getId());

		this.carDao.deleteById(car.getId());
		return new SuccessResult(Messages.CARDELETE);
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(this.carDao.findAll(), Messages.CARLIST);
	}

	@Override
	public DataResult<Car> findById(int id) {
		return new SuccessDataResult<Car>(this.carDao.findById(id).get());
	}

	@Override
	public DataResult<List<CarDetailDto>> getCarsWithBrandAndColorDetails() {
		List<CarDetailDto> cars = this.carDao.getCarsWithBrandAndColorDetails();
		return new SuccessDataResult<List<CarDetailDto>>(cars, Messages.CARLIST);
	}

}

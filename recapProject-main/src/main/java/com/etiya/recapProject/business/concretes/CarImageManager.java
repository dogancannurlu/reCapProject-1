package com.etiya.recapProject.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.CarImageService;
import com.etiya.recapProject.business.constants.Messages;
import com.etiya.recapProject.core.business.BusinessRules;
import com.etiya.recapProject.core.business.İmagePaths;
import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.ErrorResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.core.utilities.results.SuccessDataResult;
import com.etiya.recapProject.core.utilities.results.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.concretes.CarImage;
import com.etiya.recapProject.entities.requests.createRequests.CreateCarImageRequest;
import com.etiya.recapProject.entities.requests.deleteRequests.DeleteCarImageRequest;
import com.etiya.recapProject.entities.requests.updateRequests.UpdateCarImageRequest;

@Service
public class CarImageManager implements CarImageService {

	CarImageDao carImageDao;
	

	@Autowired
	public CarImageManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) {
		var result = BusinessRules.run(checkCountImagesOfCar(createCarImageRequest.getCarId(), 5),checkDefaultImage(createCarImageRequest.getCarId()));
		if (result != null) {
			return result;
		}
		

		Car car = new Car();
		car.setId(createCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setCar(car);

		String imageGUID = java.util.UUID.randomUUID().toString();
		
		LocalDate dateNow = LocalDate.now();
		carImage.setDate(dateNow);
		
		carImage.setImagePath("images\\carImages\\" + imageGUID + ".jpeg");
		
		this.carImageDao.save(carImage);

		return new SuccessResult(Messages.CARIMAGEADD);
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) {
		Car car = new Car();
		car.setId(updateCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setCar(car);

		String imageGUID = java.util.UUID.randomUUID().toString();
		LocalDate dateNow = LocalDate.now();
		carImage.setDate(dateNow);
		carImage.setImagePath("images\\carImages\\" + imageGUID + ".jpeg");

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CARIMAGEUPDATE);

	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		Car car = new Car();
		car.setId(deleteCarImageRequest.getCarId());
		
		this.carImageDao.deleteById(car.getId());
		return new SuccessResult(Messages.CARIMAGEDELETE);
	}

	@Override
	public DataResult<List<CarImage>> getAll() {

		return new SuccessDataResult<List<CarImage>>(this.carImageDao.findAll(), Messages.CARIMAGELIST);
	}

	@Override
	public DataResult<List<CarImage>> getImagesWithCarId(int carId) {

		return new SuccessDataResult<List<CarImage>>(this.carImageDao.getByCar_Id(carId), Messages.CARIMAGELIST);
	}

	private Result checkCountImagesOfCar(int carId, int limit) {
		if (this.carImageDao.countCarImageByCar_Id(carId) >= limit) {

			return new ErrorResult(Messages.CARIMAGEERROR);
		}
		return new SuccessResult();
	}
	private Result checkDefaultImage( int carId) {
		
		if(this.carImageDao.getByCar_Id(carId).get(0).getImagePath()==İmagePaths.CARDEFAULTIMAGEPATH) {
			this.carImageDao.deleteAll();
			System.out.println("dene12");
		}
		return new SuccessResult();
		
	}

}

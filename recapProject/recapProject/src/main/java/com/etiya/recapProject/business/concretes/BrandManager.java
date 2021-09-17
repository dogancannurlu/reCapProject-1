package com.etiya.recapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.BrandService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.core.utilities.SuccessDataResult;
import com.etiya.recapProject.core.utilities.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.BrandDao;
import com.etiya.recapProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	BrandDao brandDao;

	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public Result add(Brand entity) {
		this.brandDao.save(entity);
		return new SuccessResult("Marka eklendi.");
	}

	@Override
	public Result update(Brand entity) {
		this.brandDao.save(entity);
		return new SuccessResult("Marka güncellendi.");

	}

	@Override
	public Result delete(Brand entity) {
		this.brandDao.delete(entity);
		return new SuccessResult("Marka silindi.");

	}

	@Override
	public DataResult<List<Brand>> getAll() {

		return new SuccessDataResult<List<Brand>>(this.brandDao.findAll(), "Markalar listelendi.");
	}

	@Override
	public DataResult<Brand> getById(int id) {

		return new SuccessDataResult<Brand>(this.brandDao.findById(id).get(), "Id'ye göre marka getirildi.");
	}

}

package com.etiya.recapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.ColorService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.core.utilities.SuccessDataResult;
import com.etiya.recapProject.core.utilities.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.ColorDao;
import com.etiya.recapProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService {
	ColorDao colorDao;

	@Autowired

	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>> getAll() {

		return new SuccessDataResult<List<Color>>(this.colorDao.findAll(), "Renkler listelendi.");
	}

	@Override
	public DataResult<Color> getById(int id) {

		return new SuccessDataResult<Color>(this.colorDao.findById(id).get(), "Id'ye göre renk getirildi.");
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("Color eklendi.");

	}

	@Override
	public Result update(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("Color güncellendi.");
	}

	@Override
	public Result delete(Color color) {
		this.colorDao.delete(color);
		return new SuccessResult("Color silindi.");

	}

}

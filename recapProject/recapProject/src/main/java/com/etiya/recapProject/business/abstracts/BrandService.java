package com.etiya.recapProject.business.abstracts;

import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.entities.concretes.Brand;

public interface BrandService extends CrudService<Brand> {

	DataResult<Brand> getById(int id);
}

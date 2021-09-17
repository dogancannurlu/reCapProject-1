package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;

public interface CrudService<T> {

	Result add(T entity);

	Result update(T entity);

	Result delete(T entity);

	DataResult<List<T>>getAll();
}

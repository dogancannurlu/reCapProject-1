package com.etiya.recapProject.business.abstracts;

import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.entities.concretes.Color;

public interface ColorService extends CrudService<Color> {

	DataResult<Color> getById(int id);
}

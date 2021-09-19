package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Rental;
import com.etiya.recapProject.entities.requests.createRequests.CreateRentalRequest;
import com.etiya.recapProject.entities.requests.deleteRequests.DeleteRentalRequest;
import com.etiya.recapProject.entities.requests.updateRequests.UpdateRentalRequest;

public interface RentalService {
	Result add(CreateRentalRequest createRentalRequest);

	Result update(UpdateRentalRequest updateRentalRequest);

	Result delete(DeleteRentalRequest deleteRentalRequest);

	DataResult<List<Rental>> getAll();
}

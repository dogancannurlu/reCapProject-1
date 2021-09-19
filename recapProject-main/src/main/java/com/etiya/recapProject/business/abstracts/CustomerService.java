package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Customer;
import com.etiya.recapProject.entities.requests.createRequests.CreateCustomerRequest;
import com.etiya.recapProject.entities.requests.deleteRequests.DeleteCustomerRequest;
import com.etiya.recapProject.entities.requests.updateRequests.UpdateCustomerRequest;

public interface CustomerService {
	Result add(CreateCustomerRequest createCustomerRequest);

	Result update(UpdateCustomerRequest updateCustomerRequest);

	Result delete(DeleteCustomerRequest deleteCustomerRequest);

	DataResult<List<Customer>> getAll();
}

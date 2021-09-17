package com.etiya.recapProject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.recapProject.business.abstracts.BrandService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.entities.concretes.Brand;
@RestController
@RequestMapping("api/brands")
public class BrandsController {
	BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Brand>> getAll() {

		return this.brandService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Brand> getById(int brandId) {
		return this.brandService.getById(brandId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Brand brand) {
		return this.brandService.add(brand);
	}

	@PostMapping("updateBrand")
	public Result update(Brand brand) {
		return this.brandService.update(brand);
	}

	@PutMapping("deleteBrand")
	public Result delete(Brand brand) {
		return this.brandService.delete(brand);
	}
}
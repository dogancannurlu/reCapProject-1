package com.etiya.recapProject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.recapProject.business.abstracts.ColorService;
import com.etiya.recapProject.core.utilities.DataResult;
import com.etiya.recapProject.core.utilities.Result;
import com.etiya.recapProject.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorsController {
	ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Color> getById(int brandId) {
		return this.colorService.getById(brandId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);
	}

	@PostMapping("updatecolor")
	public Result update(Color color) {
		return this.colorService.update(color);
	}

	@PutMapping("deletecolor")
	public Result delete(Color color) {
		return this.colorService.delete(color);
	}
}

package com.etiya.recapProject.entities.requests.createRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {

	private int carId;
	private String imagePath;
	
}

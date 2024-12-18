package com.example.vra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vra.entity.Vehicle;
import com.example.vra.requestdto.VehicleRequest;
import com.example.vra.responsedto.VehicleResponse;
import com.example.vra.service.VehicleService;
import com.example.vra.util.ResponseStructure;
import com.example.vra.util.SimpleResponseStructure;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;
	
	VehicleController(VehicleService vehicleService){
		super();
		this.vehicleService=vehicleService;
	}
	@PostMapping("/add-vehicle")
	public ResponseEntity<ResponseStructure<VehicleResponse>> addVehicle(@RequestBody VehicleRequest request){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.OK.value(),"Vehicle Details Added",vehicleService.addVehicle(request)));
	}
	@PostMapping("/update-vehicle")
	public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@RequestBody VehicleRequest request,@RequestParam int vehicleId){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(ResponseStructure.create(HttpStatus.OK.value(),"Vehicle Details Updated",vehicleService.updateVehicle(request,vehicleId)));
	}
	@GetMapping("/get-vehicle")
	public ResponseEntity<SimpleResponseStructure> deleteVehicle(@RequestParam int vehicleId){
		return ResponseEntity.status(HttpStatus.CREATED).
				body(SimpleResponseStructure.create(HttpStatus.OK.value(),"Vehicle Deleted"));
	}
	@GetMapping("/get-all-vehicle-entity")
	public List<Vehicle> getMethodName(@RequestParam String param) {
		return vehicleService.getAllVehicle();
	}
	
}

package com.example.vra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vra.entity.Vehicle;
import com.example.vra.exception.VehicleNotFoundById;
import com.example.vra.mapper.VehicleMapper;
import com.example.vra.repository.VehicleRepository;
import com.example.vra.requestdto.VehicleRequest;
import com.example.vra.responsedto.VehicleResponse;

@Service
public class VehicleService {
	private final VehicleRepository repository;
	private final VehicleMapper mapper;

	VehicleService(VehicleRepository repository,VehicleMapper mapper){
		super();
		this.repository=repository;
		this.mapper=mapper;
	}

	public VehicleResponse addVehicle(VehicleRequest request) {
		return mapper.mapToVehicleResponse(repository.save(mapper.mapToVehicle(request, new Vehicle())));
	}

	public VehicleResponse updateVehicle(VehicleRequest request,int vehicleId) {
		return repository.findById(vehicleId).map((vehicle)->{
			vehicle=mapper.mapToVehicle(request, vehicle);
			return mapper.mapToVehicleResponse(repository.save(vehicle));
		}).orElseThrow(()->new VehicleNotFoundById("Vehicle Not Found"));
	}

	public void deleteVehicle(int vehicleId) {
		repository.findById(vehicleId).ifPresentOrElse(vehicle->{
			repository.delete(vehicle);
		}, ()->new VehicleNotFoundById("Vehicle Not Find By Id"));
	}

	public List<Vehicle> getAllVehicle() {
		return repository.findAll();
	}
}

package com.example.vra.mapper;

import org.springframework.stereotype.Component;

import com.example.vra.entity.Vehicle;
import com.example.vra.requestdto.VehicleRequest;
import com.example.vra.responsedto.VehicleResponse;

@Component
public class VehicleMapper {

	public Vehicle mapToVehicle(VehicleRequest request,Vehicle vehicle) {
		vehicle.setVehicleBrand(request.getVehicleBrand());
		vehicle.setVehicleFuelType(request.getVehicleFuelType());
		vehicle.setVehicleModel(request.getVehicleModel());
		vehicle.setType(request.getType());
		return vehicle;
	}
	
	public VehicleResponse mapToVehicleResponse(Vehicle vehicle) {
		VehicleResponse vehicleResponse=new VehicleResponse();
		vehicleResponse.setType(vehicle.getType());
		vehicleResponse.setVehicleBrand(vehicle.getVehicleBrand());
		vehicleResponse.setVehicleFuelType(vehicle.getVehicleFuelType());
		vehicleResponse.setVehicleId(vehicle.getVehicleId());
		vehicleResponse.setVehicleModel(vehicle.getVehicleModel());
		return vehicleResponse;
	}
}
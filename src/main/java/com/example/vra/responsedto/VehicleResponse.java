package com.example.vra.responsedto;

import com.example.vra.enums.VehicleFuelType;
import com.example.vra.enums.VehicleType;

public class VehicleResponse {
	private int vehicleId;
	private String vehicleBrand;
	private VehicleType type;
	private String vehicleModel;
	private VehicleFuelType vehicleFuelType;

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public VehicleFuelType getVehicleFuelType() {
		return vehicleFuelType;
	}
	public void setVehicleFuelType(VehicleFuelType vehicleFuelType) {
		this.vehicleFuelType = vehicleFuelType;
	}
}

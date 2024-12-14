package com.example.vra.entity;

import com.example.vra.enums.VehicleFuelType;
import com.example.vra.enums.VehicleType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

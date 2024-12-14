package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vra.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}

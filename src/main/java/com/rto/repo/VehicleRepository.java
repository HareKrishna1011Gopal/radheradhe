package com.rto.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rto.entity.VehicleDetailsEntity;

public interface VehicleRepository extends JpaRepository<VehicleDetailsEntity,Serializable> {

	@Query(value = "select e from VehicleDetailsEntity e where e.ownerdetailsentity.ownerId=:ownId")
	public VehicleDetailsEntity getAllDetailsById(Integer ownId);
	
}

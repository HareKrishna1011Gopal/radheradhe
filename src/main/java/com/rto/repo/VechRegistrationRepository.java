package com.rto.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rto.entity.VehicleRegistrationEntity;

public interface VechRegistrationRepository extends JpaRepository<VehicleRegistrationEntity, Serializable> {

	@Query(value = "select e from VehicleRegistrationEntity e where vregNumber=:regNo")
	public VehicleRegistrationEntity getOwnerIdForRest(String regNo);
	
	@Query(value = "select e from VehicleRegistrationEntity e where e.ownerdetailsentity.ownerId=:ownId")
	public VehicleRegistrationEntity getAllDetailsById(Integer ownId);
}

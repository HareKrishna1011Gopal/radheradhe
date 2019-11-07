package com.rto.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rto.entity.AddresDetailsEntity;

public interface AddressRepository extends JpaRepository<AddresDetailsEntity, Serializable> {

	@Query(value = "select e from AddresDetailsEntity e where e.ownerdetailsentity.ownerId=:ownId")
	public AddresDetailsEntity getAllDetailsById(Integer ownId);
}

package com.rto.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.entity.OwnerDetailsEntity;

public interface OwnerRepository extends JpaRepository<OwnerDetailsEntity, Serializable>{
   
}

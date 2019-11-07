package com.rto.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rto.entity.OwnerDetailsEntity;
import com.rto.model.OwnerDetailsModel;
import com.rto.repo.OwnerRepository;

@SpringBootTest
public class VehicleRegistrationUnitTesting {
   
	@InjectMocks
	VehicleRegistrationService service;
	
	@Mock
    OwnerRepository ownerRepo;
	
	@Test
	public void saveOwnerDetailsPositive() {
		OwnerDetailsModel ownerModel=new OwnerDetailsModel();
		
		
        OwnerDetailsEntity entity=new OwnerDetailsEntity();
		entity.setOwnerId(101);
		entity.setFname("Raja");
		entity.setLname("Rani");
		entity.setDob("12-oct-2000");
		entity.setEmail("raja@gmail.com");
		entity.setGender("M");
		entity.setPhNo(999999999);
		entity.setSsn("123344");
		entity.setCreateDate(new Date());
		entity.setUpdDate(new Date());
		
		when(ownerRepo.save(entity)).thenReturn(entity);
		
		//invoke service method
		Integer res = service.saveOwnerDetails(ownerModel);
		assertNotNull(res);
	}
}

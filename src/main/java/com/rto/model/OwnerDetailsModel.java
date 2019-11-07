package com.rto.model;

import lombok.Data;
/**
 * This is OwnerDetailsModel pojo class used to store form data
 * @author bhupalp
 *
 */
@Data
public class OwnerDetailsModel {
	private Integer ownerId;
   private String fname;
   private String lname;
   private String gender;
   private String email;
   private String dob;
   private long phNo;
   private String ssn;
}

package com.rto.model;

import java.util.Date;

import lombok.Data;
/**
 * This is VehicleRegistrationModel pojo class used to store form data
 * @author bhupalp
 *
 */
@Data
public class VehicleRegistrationModel {
     private Date regdate;
     private String regcenter;
}

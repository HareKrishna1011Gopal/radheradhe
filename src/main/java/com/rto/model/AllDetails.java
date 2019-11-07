package com.rto.model;

import lombok.Data;
/**
 *  This is pojo class used to store form data
 * @author bhupalp
 *
 */
@Data
public class AllDetails {
     private OwnerDetailsModel owDetail;
     private VehicleDetailsModel vehDetails;
     private AddresDetailsModel addreDetails;
}

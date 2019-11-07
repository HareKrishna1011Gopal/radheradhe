package com.rto.model;

import lombok.Data;
/**
 * This is pojo class used to store form data
 * @author bhupalp
 *
 */
@Data
public class AddresDetailsModel {
	    private Integer addrId;
        private String houseno;
        private String street;
        private String city;
        private String zip;
}

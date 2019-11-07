package com.rto.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
/**
 *  This is OwnerDetails entity class which will talk to repository 
 * @author bhupalp
 *
 */
@Data
@Entity
@Table(name = "OwnerDetails_RTO1")
public class OwnerDetailsEntity {
	@Id
	@Column(name = "OWNER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "owner_id_generator")
	@SequenceGenerator(name ="owner_id_generator",initialValue = 1,allocationSize = 1,sequenceName = "owner_id_seq")
	private Integer ownerId;
	@Column(name = "FIRST_NAME")
    private String fname;
	@Column(name = "LAST_NAME")
    private String lname;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "EMAIL")
    private String email;
	@Column(name = "DateOFBirth")
    private String dob;
	@Column(name = "Ph_No")
	private long phNo;
	@Column(name = "SSN")
    private String ssn;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updDate;
}

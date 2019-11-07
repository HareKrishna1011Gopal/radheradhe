package com.rto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
/**
 *  This is VehicleDetails entity class which will talk to repository 
 * @author bhupalp
 *
 */
@Data
@Entity
@Table(name = "VehicleDetails_RTO1")
public class VehicleDetailsEntity {
	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehicle_id_generator")
	@SequenceGenerator(name ="vehicle_id_generator",initialValue = 1,allocationSize = 1,sequenceName = "vehicle_id_seq")
	private Integer vehicleId;
	
	@Column(name ="VEHICLE_TYPE")
	private String vtype;
	@Column(name ="VEHICLE_MODEL")
	private String model;
	@Column(name ="VEHICLE_COMPANY")
	private String vname;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updDate;
	
	@OneToOne
	@JoinColumn(name = "OWNER_ID",referencedColumnName ="OWNER_ID",nullable = false)
	private OwnerDetailsEntity ownerdetailsentity;
}

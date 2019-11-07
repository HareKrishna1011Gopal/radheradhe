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
 * This is AddressDetails entity class which will talk to repository 
 * @author bhupalp
 *
 */
@Data
@Entity
@Table(name = "AddressDetails_RTO1")
public class AddresDetailsEntity {

	@Id
	@Column(name = "ADDRES_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addres_id_generator")
	@SequenceGenerator(name = "addres_id_generator", initialValue = 1, allocationSize = 1, sequenceName = "addres_id_seq")
	private Integer addrId;
	@Column(name = "HOUSE_NO")
	private String houseno;
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ZIP_CODE")
	private String zip;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updDate;
	
	@OneToOne
	@JoinColumn(name = "OWNER_ID", referencedColumnName ="OWNER_ID",nullable = false)
	private OwnerDetailsEntity ownerdetailsentity;
}

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
 *  This is VehicleRegistration entity class which will talk to repository 
 * @author bhupalp
 *
 */
@Data
@Entity
@Table(name = "Vehicle_Regst_Dtls_RTO1")
public class VehicleRegistrationEntity {
    @Id
    @Column(name = "VCL_REG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vcl_reg_generator")
	@SequenceGenerator(name ="vcl_reg_generator",initialValue = 1,allocationSize = 1,sequenceName = "vcle_reg_seq")
	private Integer vregId;
    @Column(name = "VCL_REG_NO")
	private String vregNumber;
    @Column(name = "REG_DATE")
    private Date regdate;
    @Column(name = "CENTER")
	private String regcenter;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updDate;

	@OneToOne
	@JoinColumn(name = "OWNER_ID")
	private OwnerDetailsEntity ownerdetailsentity;
}


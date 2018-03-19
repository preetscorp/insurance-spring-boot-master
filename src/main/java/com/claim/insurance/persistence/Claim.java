package com.claim.insurance.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer claimId;

	Integer userId;
	Integer policyNo;
	Integer vehicleNo;
	Integer dlNo;

	@Column(name = "ClaimStatus", nullable = false)
	String claimStatus = "INPROGRESS";

	BigDecimal claimAmt;
	Integer insuranceProviderId;
	String createBy;
	String updateBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	LocalDateTime createTs;
	@JsonFormat(pattern = "MM/dd/yyyy")
	LocalDateTime updateTs;

	byte[] image;

	public Claim() {
	}

	public Claim(Integer userId, Integer policyNo, Integer vehicleNo, Integer dlNo, BigDecimal claimAmt,
			Integer insuranceProviderId, String createBy, LocalDateTime createDt) {
		super();
		this.userId = userId;
		this.policyNo = policyNo;
		this.vehicleNo = vehicleNo;
		this.dlNo = dlNo;
		this.claimAmt = claimAmt;
		this.insuranceProviderId = insuranceProviderId;
		this.createBy = createBy;
		this.createTs = createDt;
	}

	public Claim(Integer userId, Integer policyNo, Integer vehicleNo, Integer dlNo, BigDecimal claimAmt,
			Integer insuranceProviderId, String createBy, LocalDateTime createts, String status) {
		this(userId, policyNo, vehicleNo, dlNo, claimAmt, insuranceProviderId, createBy, createts);
		this.claimStatus = status;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}

	public Integer getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(Integer vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Integer getDlNo() {
		return dlNo;
	}

	public void setDlNo(Integer dlNo) {
		this.dlNo = dlNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public BigDecimal getClaimAmt() {
		return claimAmt;
	}

	public void setClaimAmt(BigDecimal claimAmt) {
		this.claimAmt = claimAmt;
	}

	public Integer getInsuranceProviderId() {
		return insuranceProviderId;
	}

	public void setInsuranceProviderId(Integer insuranceProviderId) {
		this.insuranceProviderId = insuranceProviderId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public LocalDateTime getCreateTs() {
		return createTs;
	}

	public void setCreateTs(LocalDateTime createTs) {
		this.createTs = createTs;
	}

	public LocalDateTime getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(LocalDateTime updateTs) {
		this.updateTs = updateTs;
	}

}

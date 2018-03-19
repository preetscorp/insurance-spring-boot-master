package com.claim.insurance.model;

import java.math.BigDecimal;

public class ClaimRequest {

	Integer userId;
	BigDecimal claimAmt;
	Integer policyNo;
	Integer vehicleNo;
	Integer dlNo;
	Integer insuranceCompanyid;
	//document
	byte[] image;
	
	String createBy;
	
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Integer getUserId() {
		return userId;
	}
	public BigDecimal getClaimAmt() {
		return claimAmt;
	}
	public void setClaimAmt(BigDecimal claimAmt) {
		this.claimAmt = claimAmt;
	}
	public Integer getInsuranceCompanyid() {
		return insuranceCompanyid;
	}
	public void setInsuranceCompanyid(Integer insuranceCompanyid) {
		this.insuranceCompanyid = insuranceCompanyid;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}

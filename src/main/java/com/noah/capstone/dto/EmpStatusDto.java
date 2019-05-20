package com.noah.capstone.dto;

import org.springframework.beans.BeanUtils;

import com.noah.capstone.dao.Status;

public class EmpStatusDto {
	
	private int employeeId;
	private String empStatus;
	
	public EmpStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpStatusDto(int employeeId, String empStatus) {
		super();
		this.employeeId = employeeId;
		this.empStatus = empStatus;
	}
	
	public EmpStatusDto(Status status) {
		BeanUtils.copyProperties(status, this);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "EmpStatusDto [employeeId=" + employeeId + ", empStatus=" + empStatus + "]";
	}

}

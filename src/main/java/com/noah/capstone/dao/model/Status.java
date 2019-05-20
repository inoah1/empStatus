package com.noah.capstone.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_status")
public class Status {
	
	@Id
	private int employeeId;
	private String empStatus;
	
	public Status() {
		super();
	}

	public Status(int employeeId, String empStatus) {
		super();
		this.employeeId = employeeId;
		this.empStatus = empStatus;
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
		return "Status [employeeId=" + employeeId + ", empStatus=" + empStatus + "]";
	}
	

}

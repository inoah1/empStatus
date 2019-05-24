package com.noah.capstone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noah.capstone.dao.Status;
import com.noah.capstone.repository.StatusRepository;
import com.noah.capstone.util.EmployeeStatusConstants;

@Service
public class StatusService {
	
	Logger logger = LoggerFactory.getLogger(StatusService.class);
	
	@Autowired
	private StatusRepository repository;

	public Iterable<Status> getEmployeeStatus() {
		logger.info("Retrieving all employee status");
		Iterable<Status> result = repository.findAll();
		return result;
	}
	
	public Status getEmpStatus(int employeeId) {
		logger.info("Getting status for employeeId " + employeeId);
		try {
			Status status = repository.findByEmployeeId(employeeId);
			if(status == null) {
				logger.debug("Could not find employeeId " + employeeId);
				return new Status(employeeId, EmployeeStatusConstants.NOT_FOUND_MSG);
			}
			return status;
		} catch (Exception e) {
			logger.error("Exception while getting employee status", e);
			return new Status(employeeId, EmployeeStatusConstants.NOT_FOUND_MSG);
		}
	}
	
	public Status updateStatus(int employeeId, String newStatus) {
		logger.info("Updating status for employeeId " + employeeId + ", new status = " + newStatus);
		try {
			Status empStatus = repository.findByEmployeeId(employeeId);
			if(empStatus == null) {
				logger.debug("Could not find employeeId " + employeeId);
				return new Status(employeeId, EmployeeStatusConstants.NOT_FOUND_MSG);
			}
			empStatus.setEmpStatus(newStatus);
			
			Status updatedEmpStatus = repository.save(empStatus);
			return updatedEmpStatus;
		} catch (Exception e) {
			logger.error("Exception while updating employee status", e);
			return new Status(employeeId, EmployeeStatusConstants.NOT_FOUND_MSG);
		}
	}
	
	public Status deleteEmp(int employeeId) {
		logger.info("Deleting employeeId " + employeeId);
		try {
			repository.deleteById(employeeId);
			Status result = new Status(employeeId, EmployeeStatusConstants.DELETED_MSG);
			return result;
		} catch (Exception e) {
			logger.error("Exception while deleting employee status", e);
			return new Status(employeeId, EmployeeStatusConstants.NOT_FOUND_MSG);
		}
	}
	
	public String addEmpStatus(int employeeId, String newStatus) {
		logger.info("Adding employeeId " + employeeId);
		try {
			Status empStatus = new Status(employeeId, newStatus);
			repository.save(empStatus);
			return "Saved";
		} catch (Exception e) {
			logger.error("Exception while adding new employee status", e);
			return "Exception";
		}
	}

}

package com.noah.capstone.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.noah.capstone.dao.model.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
	
	Status findByEmployeeId(int employeeId);

}

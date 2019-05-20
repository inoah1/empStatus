package com.noah.capstone.repository;

import org.springframework.data.repository.CrudRepository;

import com.noah.capstone.dao.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
	
	Status findByEmployeeId(int employeeId);

}

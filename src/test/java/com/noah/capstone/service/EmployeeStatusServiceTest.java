package com.noah.capstone.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.noah.capstone.dao.Status;
import com.noah.capstone.repository.StatusRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeStatusServiceTest {
	@Mock
	private StatusRepository repository;
	
	@InjectMocks
	private final StatusService service = new StatusService();

	@Test
	public void whenEmployeeFound_thenReturnEmployeeStatus() throws Exception {

		int employeeId = 11111;

		given(repository.findByEmployeeId(employeeId)).willReturn(getMockStatus(employeeId, "Active"));
		
		Status status = service.getEmpStatus(employeeId);
		assertNotNull(status);
		assertEquals(status.getEmployeeId(),employeeId);
		assertEquals(status.getEmpStatus(), "Active");		
	}
	
	@Test
	public void whenInactiveEmployeeFound_thenReturnInactiveStatus() throws Exception {
		
		int employeeId = 33333;
		
		given(repository.findByEmployeeId(employeeId)).willReturn(getMockStatus(employeeId, "Seperated"));
		
		Status status = service.getEmpStatus(employeeId);
		assertNotNull(status);
		assertEquals(status.getEmployeeId(),employeeId);
		assertEquals(status.getEmpStatus(), "Seperated");
		
	}
	
	@Test
	public void whenEmployeeNotFound_thenReturnErrorMsg() throws Exception {
		int employeeId = 0;
		
		Status status = service.getEmpStatus(employeeId);
		assertNotNull(status);
		assertEquals(status.getEmpStatus(), "NOT_FOUND");
	}

	private Status getMockStatus(int employeeId, String empStatus) {
		Status status = new Status();
		status.setEmployeeId(employeeId);
		status.setEmpStatus(empStatus);

		return status;
	}

}

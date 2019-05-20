package com.noah.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.noah.capstone.dao.Status;
import com.noah.capstone.dto.EmpStatusDto;
import com.noah.capstone.service.StatusService;

@RestController
@RequestMapping(path = "/empstatus")
public class EmployeeStatusController {
	
	@Autowired
	private StatusService service;
	
	Logger logger = LoggerFactory.getLogger(EmployeeStatusController.class);
	
	@RequestMapping(path = "/info", produces = MediaType.TEXT_HTML_VALUE)
	private String info() {
		return "Employee Status service is up and running";
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<EmpStatusDto> getEmployeeStatus() {
		logger.info("Get all employee status");
		Iterable<Status> dbList = service.getEmployeeStatus();
		List<EmpStatusDto> returnList = new ArrayList<>();
		
		for (Status status : dbList) {
			EmpStatusDto returnDto = new EmpStatusDto(status);			
			returnList.add(returnDto);
		}
		
		return returnList;
	}
	
	@GetMapping(path = "/getstatus/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpStatusDto getEmpStatus(@PathVariable("employeeId") int employeeId) {
		Status status = service.getEmpStatus(employeeId);
		EmpStatusDto returnDto = new EmpStatusDto(status);
		return returnDto;
	}
	
	@PutMapping(path = "/updatestatus/{employeeId}/{newStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpStatusDto updateStatus(@PathVariable("employeeId") int employeeId, @PathVariable("newStatus") String newStatus) {
		Status status = service.updateStatus(employeeId, newStatus);
		EmpStatusDto returnDto = new EmpStatusDto(status);
		return returnDto;
	}
	
	@DeleteMapping(path = "/delete/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpStatusDto deleteEmp(@PathVariable("employeeId") int employeeId) {
		Status status =  service.deleteEmp(employeeId);
		EmpStatusDto returnDto = new EmpStatusDto(status);
		return returnDto;
	}
	
	@GetMapping(path = "/add", produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String addEmpStatus(@RequestParam int employeeId, @RequestParam String newStatus) {
		return service.addEmpStatus(employeeId, newStatus);
	}

}

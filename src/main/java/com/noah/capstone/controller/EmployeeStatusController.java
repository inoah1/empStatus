package com.noah.capstone.controller;

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

import com.noah.capstone.dao.model.Status;
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
	public @ResponseBody Iterable<Status> getEmployeeStatus() {
		logger.info("Get all employee status");
		return service.getEmployeeStatus();		
	}
	
	@GetMapping(path = "/getstatus/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Status getEmpStatus(@PathVariable("employeeId") int employeeId) {
		return service.getEmpStatus(employeeId);
	}
	
	@PutMapping(path = "/updatestatus/{employeeId}/{newStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Status updateStatus(@PathVariable("employeeId") int employeeId, @PathVariable("newStatus") String newStatus) {
		return service.updateStatus(employeeId, newStatus);
	}
	
	@DeleteMapping(path = "/delete/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Status deleteEmp(@PathVariable("employeeId") int employeeId) {
		return service.deleteEmp(employeeId);
	}
	
	@GetMapping(path = "/add", produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String addEmpStatus(@RequestParam int employeeId, @RequestParam String newStatus) {
		return service.addEmpStatus(employeeId, newStatus);
	}

}

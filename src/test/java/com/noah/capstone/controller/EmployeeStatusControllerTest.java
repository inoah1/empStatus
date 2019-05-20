package com.noah.capstone.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noah.capstone.dao.Status;
import com.noah.capstone.dto.EmpStatusDto;
import com.noah.capstone.repository.StatusRepository;
import com.noah.capstone.service.StatusService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeStatusController.class)
public class EmployeeStatusControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean(name = "testRepository")
	private StatusRepository repository;
	
	@MockBean
	private StatusService service;

	//TODO: fix failing test
	@Test
	public void whenEmployeeFound_thenReturnEmployeeStatus() throws Exception {

		int employeeId = 11111;

		given(repository.findByEmployeeId(employeeId)).willReturn(getMockStatus(employeeId));

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/empstatus/getstatus/{employeeId}", employeeId)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(getResponseJsonData(employeeId, "Active")));
	}
	
	//TODO: add more test cases

	private String getResponseJsonData(int employeeId, String empStatus) throws JsonProcessingException {
		EmpStatusDto empStatusDto = new EmpStatusDto(employeeId, empStatus);

		String json = objectMapper.writeValueAsString(empStatusDto);
		return json;
	}

	private Status getMockStatus(int employeeId) {
		Status status = new Status();
		status.setEmployeeId(employeeId);
		status.setEmpStatus("Active");

		return status;
	}

}

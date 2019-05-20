package com.noah.capstone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpStatusApplicationTests {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertNotNull("Controller must be autowired", context);
	}
	
	@Test
	public void getAllEmployees() {
		ResponseEntity<Iterable> response = this.restTemplate.getForEntity("/empstatus/all", Iterable.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}

package com.us.shipwreck;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ShipwreckWebIntegrationTest {
	

	@Test
	public void testFindAll() {
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8181/api/v1/shipwrecks", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseJson = null;
		try {
			responseJson = mapper.readTree(response.getBody());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseJson.toString());
		assertEquals(responseJson.isMissingNode(), false);
		assertFalse(responseJson.toString().isEmpty());
		
		//in db should be at least one record
		assertFalse(responseJson.toString().length()<3);
		
	}

}

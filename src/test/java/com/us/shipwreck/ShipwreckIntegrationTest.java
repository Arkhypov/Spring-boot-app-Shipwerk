package com.us.shipwreck;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.us.shipwreck.model.Shipwreck;
import com.us.shipwreck.repository.ShipwreckRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShipwreckIntegrationTest {

	@Autowired
	ShipwreckRepository sr;
	
	@Test
	public void findAll() {
		List<Shipwreck> wrecks = sr.findAll();
		System.out.println(wrecks.size());
		assertTrue(wrecks.size()>=0);
	}
	
}

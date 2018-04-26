package com.us.shipwreck;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.us.shipwreck.controller.ShipwreckController;
import com.us.shipwreck.model.Shipwreck;
import com.us.shipwreck.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository sr;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shipwreckController() {
		
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		
		//mocking happens here
		when(sr.findOne(1l)).thenReturn(sw);
	
		Shipwreck shipwreck = sc.get(1l);
		assertEquals(1L, shipwreck.getId().longValue());
		
		//verify if method was called at least once. If called 2ce - will fail
		verify(sr).findOne(1l);
	}

}

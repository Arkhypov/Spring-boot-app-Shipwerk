package com.us.shipwreck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.us.shipwreck.controller.HomeControlller;

public class AppTest {
    
	@Test
	public void testApp()
    {
        HomeControlller hc = new HomeControlller();
        String result = hc.home();
		assertEquals(result,"Hello at home");
    }
}

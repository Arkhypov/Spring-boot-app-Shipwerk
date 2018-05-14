package com.us.shipwreck.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.us.shipwreck.model.Shipwreck;
import com.us.shipwreck.repository.ShipwreckRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/")
@Api(value="ShipwreckRegistry", description="Options you can do with Shipwreck Object")
public class ShipwreckController {
	
	@Autowired
	ShipwreckRepository shipwreckRep;
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	@ApiOperation(value = "View a list of available Shipwreck", response = List.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public List<Shipwreck> list(){
		return shipwreckRep.findAll();	
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	@ApiOperation(value = "Search a product with an ID",response = Shipwreck.class)
	public Shipwreck get(@PathVariable Long id){
		return shipwreckRep.findOne(id);	
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	@ApiOperation(value = "Save a shipwreck")
	public void create(@RequestBody Shipwreck wreck){
		shipwreckRep.saveAndFlush(wreck);	
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	@ApiOperation(value = "Update a shipwreck")
	public void update(@PathVariable Long id,@RequestBody Shipwreck wreck){
		//return 
		Shipwreck existing = shipwreckRep.findOne(id);
		BeanUtils.copyProperties(wreck, existing);
		shipwreckRep.saveAndFlush(existing);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	@ApiOperation(value = "Delete a shipwreck")
	public void delete(@PathVariable Long id){
		shipwreckRep.delete(id);	
	}

	
}

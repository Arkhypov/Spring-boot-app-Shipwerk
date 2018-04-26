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

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {
	
	@Autowired
	ShipwreckRepository shipwreckRep;
	
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list(){
		return shipwreckRep.findAll();	
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return shipwreckRep.findOne(id);	
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public void create(@RequestBody Shipwreck wreck){
		shipwreckRep.saveAndFlush(wreck);	
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable Long id,@RequestBody Shipwreck wreck){
		//return 
		Shipwreck existing = shipwreckRep.findOne(id);
		BeanUtils.copyProperties(wreck, existing);
		shipwreckRep.saveAndFlush(existing);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		shipwreckRep.delete(id);	
	}
	
}

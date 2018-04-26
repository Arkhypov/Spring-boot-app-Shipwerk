package com.us.shipwreck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.us.shipwreck.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {
	/*
	public List findAll();
	public void saveAndWrite(Shipwreck wreck);
	public void update(Shipwreck wreck);
	public Shipwreck findOne(Long id);
	public void delete(Long id);
	*/

}

package com.us.shipwreck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SHIPWRECK")
public class Shipwreck {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private Long id;
	
	@NotBlank
    @Column(unique = true)
    @Size(min = 1, max = 100)
	private String name;
	
	private String description;
	private String cond;
	private int depth;
	private double latitude;
	private double longitude;
	private int yearDiscovered;
	
	public Shipwreck(){}
	
	
	
	public Shipwreck(Long id, String name, String description, String condition, int depth, double latitude,
			double longitude, int yearDiscovered) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.cond = condition;
		this.depth = depth;
		this.latitude = latitude;
		this.longitude = longitude;
		this.yearDiscovered = yearDiscovered;
	}
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return cond;
	}

	public void setCondition(String condition) {
		this.cond = condition;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getYearDiscovered() {
		return yearDiscovered;
	}

	public void setYearDiscovered(int yearDiscovered) {
		this.yearDiscovered = yearDiscovered;
	}
}

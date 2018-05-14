package com.us.shipwreck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "SHIPWRECK")
public class Shipwreck {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	@ApiModelProperty(notes = "This is ID of Shipwreck")
	private Long id;
	
	@NotBlank
    @Column(unique = true)
    @Size(min = 1, max = 100)
	@ApiModelProperty(notes = "This is Name of Shipwreck", required=true)
	private String name;
	
	@ApiModelProperty(notes = "This is Description of Shipwreck")
	private String description;
	
	@ApiModelProperty(notes = "This is a Condition of Shipwreck")
	private String cond;
	
	@ApiModelProperty(notes = "This is a Depth where was found Shipwreck")
	private int depth;
	
	@ApiModelProperty(notes = "This is a Latitude where was found Shipwreck")
	private double latitude;
	
	@ApiModelProperty(notes = "This is a Longitude where was found Shipwreck")
	private double longitude;
	
	@ApiModelProperty(notes = "This is a Year when was Discovered Shipwreck")
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

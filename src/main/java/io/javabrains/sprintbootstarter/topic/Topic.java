package io.javabrains.sprintbootstarter.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // tells JPA that Topic is a table in the database with the class variables as column keys
// also, each instance of this class will be a row in the database
public class Topic {
	@Id  // marks id as the primary key
	private String id;
	private String name;
	private String description;
	
	public Topic() {
	}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
}

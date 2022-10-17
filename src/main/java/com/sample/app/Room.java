package com.sample.app;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="room")
public class Room {
	
	private String id;
	private String name;
	private String number;
	private String occupant;
	
	public Room() {
		
	}
	
	@DynamoDBHashKey(attributeName="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute(attributeName="number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@DynamoDBAttribute(attributeName="occupant")
	public String getOccupant() {
		return occupant;
	}
	public void setOccupant(String occupant) {
		this.occupant = occupant;
	}

	public String toString() {
		return "ID: " + getId() + 
				"  \nName: " + getName() + 
				"  \nNumber: " + getNumber() + 
				"  \nOccupant: " + getOccupant();
	}
}

package com.sample.app;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.*;
import com.amazonaws.regions.Regions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application 
{
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	

	@RequestMapping("/")
	public String home() {
		return "Trey's Sample API using Java, SpringBoot, AWS Lambda, and DynamoDB";
	}
	
	@GetMapping("/api/rooms")
	public String getRooms() {
		String supervisors = checkRoomStatuses();
		return supervisors;
	}
	
	private String checkRoomStatuses() {
		AmazonDynamoDB client = createDynamoDBClient();
		DynamoDB ddb = new DynamoDB(client);
		Table roomTable = ddb.getTable("room");
		
//		roomTable.
		
		String returnVal = "test";
		return returnVal;
	}
	
	@PostMapping(value = "/api/createRoom", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"} )
	public HttpStatus createRoom(@RequestBody Room room) {

		if ( room.getId() != null && room.getName() != null && room.getNumber() != null && room.getOccupant() != null) {
			DynamoDBMapper mapper = createMapper();
			mapper.save(room);
			
			return HttpStatus.ACCEPTED;
		} else {
			
			System.out.println(room);

			return HttpStatus.BAD_REQUEST;
		}

	}
	
	@PostMapping( value = "/api/updateRoom", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"} )
	public HttpStatus updateRoom(String id, String occupant) {
		if ( id != null && occupant != null) {
			
			//TODO get room based on provided ID and update with provided occupant
			Room room = new Room();
			System.out.println(room.toString());
			return HttpStatus.ACCEPTED;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	private AmazonDynamoDB createDynamoDBClient() {		
		return AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.US_EAST_1)
				.build();
		
	}
	
	private DynamoDBMapper createMapper() {
		AmazonDynamoDB client = createDynamoDBClient();
		return new DynamoDBMapper(client);
	}
}

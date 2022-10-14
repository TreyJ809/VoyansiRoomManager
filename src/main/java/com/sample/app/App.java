package com.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class App 
{
	public static void main( String[] args ) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Trey's Hello World";
	}
	
	@GetMapping("/api/rooms")
    public String getRooms() {
        String supervisors = checkRoomsStatuses();
        return supervisors;
    }
	
	private String checkRoomsStatuses() {
		return "test";
	}
}

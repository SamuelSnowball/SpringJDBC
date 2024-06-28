package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	class Test {

		@Autowired
		private JdbcTemplate jdbcTemplate;

		@GetMapping("/helloworld")
		public String myMethod(){
			String query = "SELECT * FROM trip";
			List<Trip> trips = jdbcTemplate.query(query, new TripRowMapper());

			trips.stream().forEach(t -> System.out.println("trip" + t.toString()));

			return "Sam";
		}
	}

}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

@SpringBootApplication
public class DemoApplication {

	Logger logger  = LoggerFactory.getLogger(DemoApplication.class); 

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
			trips.stream().forEach(t -> logger.info("trip" + t.toString()));

			logger.info("Executing in:" + Thread.currentThread().getName());
			return "Sam";
		}

		@GetMapping("/helloworld2")
		public String myMethod2(){
			String query = "SELECT * FROM trip";
			List<Trip> trips = jdbcTemplate.query(query, new TripRowMapper());
			trips.stream().forEach(t -> logger.info("trip" + t.toString()));

			logger.info("Executing in:" + Thread.currentThread().getName());
			return "Sam 2";
		}
	}

}

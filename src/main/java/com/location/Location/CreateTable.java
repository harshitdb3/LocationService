package com.location.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTable {
  @Autowired
  private JdbcTemplate jdbcTemplate;

	@PostMapping("/create_data")
	public ResponseEntity<Void> createtable() {
   
    jdbcTemplate.execute("CREATE TABLE user_location (name VARCHAR(255), latitude DOUBLE, longitude DOUBLE)");
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
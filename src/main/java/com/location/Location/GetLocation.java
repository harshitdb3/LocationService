package com.location.Location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.location.UserLocation;

@RestController
public class GetLocation {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/get_users")
  public List<UserLocation> getUsers() {
    String sql = "SELECT NAME,LATIITUDE,LONGITUDE FROM users";
    List<UserLocation> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserLocation.class));
    return users;
}
	
}
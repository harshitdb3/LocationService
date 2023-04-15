package com.location.Location;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetLocation {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/get_users")
  public List<UserLocation> getUserLocations() {
    String sql = "SELECT name, latitude, longitude FROM user_location";
    List<java.util.Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
    List<UserLocation> userLocations = new ArrayList<>();
    for (java.util.Map<String, Object> row : rows) {
        UserLocation userLocation = new UserLocation();
        userLocation.setName((String) row.get("name"));
        userLocation.setLatitude((Double) row.get("latitude"));
        userLocation.setLongitude((Double) row.get("longitude"));
        userLocations.add(userLocation);
    }
    return userLocations;
  }
	
}
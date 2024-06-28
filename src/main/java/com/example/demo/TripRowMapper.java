package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TripRowMapper implements RowMapper<Trip> {

    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trip trip = new Trip();

        trip.setId(rs.getInt("id"));
        trip.setTitle(rs.getString("title"));
        trip.setDescription(rs.getString("description"));
        trip.setStartDate(rs.getDate("startDate"));
        trip.setEndDate(rs.getDate("endDate"));

        return trip;
    }
    
}

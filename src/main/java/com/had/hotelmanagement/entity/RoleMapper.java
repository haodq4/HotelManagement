package com.had.hotelmanagement.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setROLE_ID(rs.getInt("ROLE_ID"));
		role.setROLE_NAME(rs.getString("ROLE_NAME"));
		role.setROLE_DESC(rs.getString("ROLE_DESC"));
		return role;
	}
}

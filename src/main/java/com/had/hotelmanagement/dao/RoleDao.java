package com.had.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.had.hotelmanagement.entity.Role;
import com.had.hotelmanagement.entity.RoleMapper;

@Repository
@Transactional
public class RoleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Role role) {
		String sql = "INSERT INTO role (ROLE_NAME,ROLE_DESC) VALUES (?,?)";	
		jdbcTemplate.update(sql, role.getROLE_NAME(),role.getROLE_DESC());
		
	}

	public void delete(int idrole) {
		String sql = "DELETE FROM role WHERE ROLE_ID = " + idrole;
		jdbcTemplate.update(sql);
	}
	
	public void update(Role role) {
		String sql = "UPDATE role SET ROLE_NAME = ?, ROLE_DESC = ?, WHERE ROLE_ID = ? ";
		jdbcTemplate.update(sql, role.getROLE_NAME(),role.getROLE_DESC(),role.getROLE_ID());
	}	
	public Role findById(int idrole) {
		String sql = "SELECT * FROM role WHERE ROLE_ID = ?";
		return jdbcTemplate.queryForObject(sql, new RoleMapper(), idrole);
	}

	public List<Role> findAll() {
		String sql = "SELECT * FROM role";
		return jdbcTemplate.query(sql, new RoleMapper());
	}
	
//	public List<Role>findnhanvienten(String tennv){
//		String sql = "SELECT * FROM role WHERE tennv LIKE '%"+tennv+"%'";
//		return jdbcTemplate.query(sql, new RoleMapper());
//	}
}

package com.had.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.had.hotelmanagement.entity.EmployeeEntity;
import com.had.hotelmanagement.entity.EmployeeMapper;



@Repository
@Transactional
public class EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(EmployeeEntity employee) {
		String sql = "INSERT INTO employee (name,birthday,governmentid,phone,email,adress,image,salary) VALUES (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, employee.getName(),employee.getBirthday(),
				employee.getGovernmanetid(),employee.getPhone(),employee.getEmail(),employee.getAddress(),employee.getImage(),employee.getSalary());
	}

	public void delete(int id) {
		String sql = "DELETE FROM employee WHERE employee_id = " + id;
		jdbcTemplate.update(sql);
	}
	
	public void update(EmployeeEntity employee) {
		String sql = "UPDATE employee SET  name = ?, birthday=? , governmentid=?, phone=?, email=?"
				+ "address=?,image=?,salary=? WHERE employee_id = ? ";
		jdbcTemplate.update(sql, employee.getName(),employee.getBirthday(),
				employee.getGovernmanetid(),employee.getPhone(),employee.getEmail(),employee.getAddress(),employee.getImage(),employee.getSalary());
	}

	public EmployeeEntity findById(int id) {
		String sql = "SELECT * FROM employee WHERE EMPLOYEE_ID = ?";
		return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
	}

	public List<EmployeeEntity> findAll() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}
	
	public List<EmployeeEntity>findEmployee(String name){
		String sql = "SELECT * FROM employee WHERE name LIKE '%"+name+"%'";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}


}

package com.had.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.had.hotelmanagement.dao.EmployeeDAO;
import com.had.hotelmanagement.entity.EmployeeEntity;



@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public List<EmployeeEntity> findAll() {
		return employeeDAO.findAll();
	}

	public EmployeeEntity findByIdEmployee(int employeeid) {
		return employeeDAO.findById(employeeid);
	}
	
	public void save(EmployeeEntity employee){
		// validate business
		employeeDAO.save(employee);
	}

	public void update(EmployeeEntity employee){
		// validate business
		employeeDAO.update(employee);
	}
	
	public void delete(int employeeid){
		// validate business
		employeeDAO.delete(employeeid);
	}
	public List<EmployeeEntity> searchEmployee(String name) {
		return employeeDAO.findEmployee(name);
	}

}

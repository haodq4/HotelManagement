package com.had.hotelmanagement.entity;

import java.util.Date;

public class EmployeeEntity {
	private int employeeid;
	private String name;
	private Date birthday;
	private int  governmanetid;
	private String phone;
	private String email;
	private String address;
	private String image;
	private Double salary;
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity(int employeeid, String name, Date birthday, int governmanetid, String phone, String email,
			String address, String image, Double salary) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.birthday = birthday;
		this.governmanetid = governmanetid;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.image = image;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [employeeid=" + employeeid + ", name=" + name + ", birthday=" + birthday
				+ ", governmanetid=" + governmanetid + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", image=" + image + ", salary=" + salary + "]";
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getGovernmanetid() {
		return governmanetid;
	}
	public void setGovernmanetid(int governmanetid) {
		this.governmanetid = governmanetid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}



	

	

}

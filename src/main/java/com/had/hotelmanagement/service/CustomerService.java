package com.had.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.had.hotelmanagement.dao.CustomerDAO;
import com.had.hotelmanagement.entity.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}
	
//	public List<KhachHang> findHoaDon(String tenkh) {
//		return hoaDonDAO.findHoaDon(tenkh);
//	}
	
//	public List<KhachHang> listKhachHang() {
//		return khachHangDAO.findAll();
//	}
//	
//	public List<SanPham> listSanPham() {
//		return sanPhamDAO.findAll();
//	}
//	
//	public List<NhanVien> listNhanVien() {
//		return nhanVienDAO.findAll();
//	}

	public Customer findById(int customerid) {
		return customerDAO.findById(customerid);
	}
	
	
	public void save(Customer customer){
		// validate business
		customerDAO.save(customer);
	}

	public void update(Customer customer){
		// validate business
		customerDAO.update(customer);
	}
	
	public void delete(int customerid){
		// validate business
		customerDAO.delete(customerid);
	}

}

package com.had.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.had.hotelmanagement.entity.Customer;
import com.had.hotelmanagement.entity.CustomerMapper;


@Repository
@Transactional
public class CustomerDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	final String SQL_FIND_CUSTOMER = "SELECT CM.CUSTOMER_ID, CM.CUSTOMER_NAME, CM.GOVERNMENT_ID, CM.CUSTOMER_ADDRESS, CM.CUSTOMER_PHONE, CM.CUSTOMER_EMAIL, CM.CUSTOMER_IMAGE, CM.CC_NUMBER   \r\n" + 
//			"FROM CUSTOMER AS CM \r\n" + 
//			"RIGHT JOIN sanpham AS SP ON HD.idsp = SP.idsp\r\n" + 
//			"RIGHT JOIN nhanvien AS NV ON HD.idnv = NV.idnv\r\n" + 
//			"RIGHT JOIN khachhang AS KH ON HD.idkh = KH.idkh\r\n" + 
//			"WHERE SP.tensp LIKE \"%?%\"\r\n" + 
//			"OR NV.tennv LIKE \"%?%\"\r\n" + 
//			"OR KH.ten LIKE \"%?%\"";

	public void save(Customer customer) {
		String sql = "INSERT INTO customer (name, governmentid, address, phone, email, image, cc_number) VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getGovernmentid(),customer.getAddress(),
				customer.getPhone(),customer.getEmail(),customer.getImage(),customer.getCcnumber());
	}

	public void delete(int customerid) {
		String sql = "DELETE FROM customer WHERE customer_id = " + customerid;
		jdbcTemplate.update(sql);
	}
	
	public void update(Customer customer) {
		String sql = "UPDATE customer SET name = ? , governmentid = ? , address = ? , phone = ? , email = ? , image = ? , cc_number = ? WHERE customer_id = ? ";
		jdbcTemplate.update(sql, customer.getName(), customer.getGovernmentid(), customer.getAddress(),
				customer.getPhone(),customer.getEmail(),customer.getImage(), customer.getCcnumber(), customer.getCustomerid());
	}

	public Customer findById(int customerid) {
		String sql = "SELECT * FROM customer WHERE customer_id = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerMapper(), customerid);
	}

	public List<Customer> findAll() {
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new CustomerMapper());
	}
	
//	public List<KhachHang> listKhachHang() {
//		String sql = "SELECT ten FROM khachhang";
//		return jdbcTemplate.query(sql, new KhachHangMapper());
//	}
	
//	public List<KhachHang> findHoaDon(String tenkh) {
//		String sql = SQL_FIND_HOA_DON;
//		return jdbcTemplate.query(sql, new KhachHangMapper(), tenkh);
//	}

}

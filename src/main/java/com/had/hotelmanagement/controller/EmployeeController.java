package com.had.hotelmanagement.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.had.hotelmanagement.entity.EmployeeEntity;
import com.had.hotelmanagement.service.EmployeeService;



@Controller
@RequestMapping(value = "")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "/employee-list" })
	public String listEmployee(Model model) {
		model.addAttribute("listEmployee", employeeService.findAll());
		return "employee-list";
	}

	@RequestMapping("/employee-save")
	public String insertEmployee(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "employee-save";
	}

	@RequestMapping("/employee-view/{idkh}")
	public String viewEmployee(@PathVariable int id, Model model) {
		EmployeeEntity employee = employeeService.findByIdhd(id);
		model.addAttribute("employee", employee);
		return "employee-view";
	}

	@RequestMapping("/employee-update/{idkh}")
	public String updateCustomer(@PathVariable int id, Model model) {
		EmployeeEntity employee = employeeService.findByIdhd(id);
		model.addAttribute("employee", employee);
		return "employee-update";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String doSaveCustomer(ModelMap model, HttpServletRequest request,
			@ModelAttribute("Employee") EmployeeEntity employee, @RequestParam("uploadImg") MultipartFile image) {
		{
			if (image.isEmpty()) {
			} else {
				try {
//					String path = "E:\\QUAN_LY_DU_AN_PHAN_MEM_AGILE\\Agile_Customers\\Agile_Customers\\Agile_Customers\\src\\main\\webapp\\resources\\image\\"
//							+ image.getOriginalFilename();

				String path = request.getSession().getServletContext().getRealPath("/resources/image/")
						+ image.getOriginalFilename();
//				System.out.print(path);
					image.transferTo(new File(path));
					employee.setImage(image.getOriginalFilename());
					employeeService.save(employee);
					model.addAttribute("messageSuccess", "Thêm thành công");
				} catch (Exception ex) {
					model.addAttribute("messageError", "Thêm thất bại");
					ex.printStackTrace();
				}
			}
			model.addAttribute("listEmployee", employeeService.findAll());
			return "employee-list";
		}
	}

	
	@RequestMapping("/updateEmployee")
	public String doUpdateHoaDon(@ModelAttribute("Employee") EmployeeEntity employee, Model model) {
		employeeService.update(employee);
		model.addAttribute("listEmployee", employeeService.findAll());
		return "employee-list";
	}

	@RequestMapping("/khachHangDelete/{idkh}")
	public String doDeleteCustomer(@PathVariable int id, Model model) {
		employeeService.delete(id);
		model.addAttribute("listEmployee", employeeService.findAll());
		return "employee-list";
	}

	@RequestMapping(value = "/employee-search")
	public String search(String name, Model model) {
		List<EmployeeEntity> employee =employeeService.searchkhachhang(name);
		model.addAttribute("search", employee);
		return "employee-search";
	}

}

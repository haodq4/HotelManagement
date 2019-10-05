package com.had.hotelmanagement.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.had.hotelmanagement.entity.Role;
import com.had.hotelmanagement.service.RoleService;


@Controller
@RequestMapping(value = "")
public class RoleController {
	@Autowired
	private RoleService sevice;

	@RequestMapping(value = { "/", "/list-role" }, method = RequestMethod.GET)
	public String listrole(Model model) {
		model.addAttribute("list", sevice.findAll());
		return "list-role";
	}
	@RequestMapping("/save-role")
	public String insertRole(Model model) {
		model.addAttribute("save", new Role());
		return "save-role";
	}

	@RequestMapping("/update-role/{ROLE_ID}")
	public String updateRole(@PathVariable int ROLE_ID, Model model) {
		Role role = sevice.findByIdhd(ROLE_ID);
		model.addAttribute("update", role);
		return "update-role";
	}
	@RequestMapping(value = "/saverole", method = RequestMethod.GET)
	public String doSaveRole(ModelMap model, HttpServletRequest request, @ModelAttribute("save") Role role) {
		sevice.save(role);
		model.addAttribute("list", sevice.findAll());
		model.addAttribute("messageSuccess", "Thành Công");
		return "list-role";
	}

	@RequestMapping(value = "/updaterole", method = RequestMethod.PUT)
	public String doUpdaterole(ModelMap model, HttpServletRequest request, @ModelAttribute("update") Role role) {
		sevice.update(role);
		model.addAttribute("messageSuccess", "Thành Công");
		model.addAttribute("list", sevice.findAll());
		return "list-role";
	}

	@RequestMapping("/roleDelete/{ROLE_ID}")
	public String doDeleterole(@PathVariable int ROLE_ID, Model model) {
		sevice.delete(ROLE_ID);
		model.addAttribute("list", sevice.findAll());
		return "list-role";
	}

}
package com.nkhurshid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkhurshid.models.Customer;
import com.nkhurshid.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerAccountController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/login")
	public String viewLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginCustomer(@RequestParam("phone-no") String phoneNo, @RequestParam("pass") String password, HttpServletRequest request) {
		
		Customer customer = customerService.loginCustomer(phoneNo, password);
		if(customer != null) {
			request.getSession().setAttribute("customer", customer);
			return "redirect:/"; 
		} 
		
		request.setAttribute("error", "The phone number or password you entered was incorrect, please try again");
		return viewLogin();
	}
	
	@GetMapping("/register")
	public String viewRegister() {
		return "register";
	}
	
	@PostMapping("/register") 
	public String registerCustomer(@RequestParam("first-name") String firstName, @RequestParam("last-name") String lastName,
			@RequestParam("door-no") int doorNo, @RequestParam("street-name") String streetName, @RequestParam("postcode") String postcode,
			@RequestParam("phone-no") String phoneNo, @RequestParam("password") String password, HttpServletRequest request) {
		
		Customer customer = customerService.registerCustomer(new Customer(firstName, lastName, doorNo, streetName, postcode, phoneNo, password));
		if(customer != null) {
			request.getSession().setAttribute("success", "Your account has been successfully registered- please login");
			// request.setAttribute("success", "Your account has been successfully registered- please login");
			return "redirect:/login"; 
		}
		
		request.setAttribute("error", "Unable to register your account at the moment- please try again later");
		return "register";	
	}
	
	@GetMapping("/logout")
	public String viewLogout(HttpServletRequest request) {
		request.getSession().removeAttribute("customer");
		return "index";
	}
	
	@GetMapping("/viewPersonalDetails")
	public String viewPersonalDetails() {
		return "view_personal_details";
	}
	
	@PostMapping("/viewPersonalDetails")
	public String updatePersonalDetails(@RequestParam("first-name") String firstName, @RequestParam("last-name") String lastName, @RequestParam("door-no") int doorNo,
			@RequestParam("street-name") String streetName, @RequestParam("postcode") String postcode, @RequestParam("phone-no") String phoneNo, @RequestParam("password") String password,
			HttpServletRequest request) {
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer.getPassword().equals(password)) {
			Customer saved = customerService.updateCustomer(new Customer(customer.getCustomerId(), firstName, lastName, doorNo, streetName, postcode, phoneNo, password));
			if(saved != null) {
				request.getSession().setAttribute("customer", saved);
				request.setAttribute("msg", "Changes successfully saved");
			} else {
				request.setAttribute("msg", "Unable to save changes, please try again");
			}
			
		} else {
			request.setAttribute("msg", "The password you entered was incorrect- please try again");
		}
		
		return "view_personal_details";
	}

}

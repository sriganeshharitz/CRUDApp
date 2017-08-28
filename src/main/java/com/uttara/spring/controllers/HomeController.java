package com.uttara.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uttara.spring.beans.RegBean;
import com.uttara.spring.constants.Constants;
import com.uttara.spring.services.SprService;

@Controller
public class HomeController {
	@Autowired
	private SprService service;
	@RequestMapping("/")
	public String displayHome() {
		System.out.println("In displayHome() of Home controller");
		return "Home";
	}
	@RequestMapping("/openRegisterView")
	public String showRegisterView(Model model) {
		System.out.println("In showRegisterView() of Home controller");
		RegBean rb = new RegBean();
		model.addAttribute("reg", rb);
		return "Register";
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("reg") @Valid RegBean rb,BindingResult result,Model model) {
		System.out.println("In HC register() regbean = "+rb);
		if(result.hasErrors()) {
			System.out.println("There are errors");
			return "Register";
		}
		else {
			String str = service.register(rb);
			if(str.equals(Constants.SUCCESS)) {
				return "Display";
			}
			else {
				model.addAttribute("errorMsg", "Registration failed");
				return "Register";
			}
		}
	}
}

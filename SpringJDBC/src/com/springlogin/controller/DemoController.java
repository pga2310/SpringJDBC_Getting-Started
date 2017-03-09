package com.springlogin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springlogin.bean.UserBean;
import com.springlogin.service.LoginServiceInterface;

@Controller
public class DemoController {
	
	@Autowired
	private LoginServiceInterface loginService;
 
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("userBean", new UserBean());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
		return "login";
	}
 
	@RequestMapping("doLogin")
	public @ResponseBody String doLogin(@ModelAttribute UserBean userBean,BindingResult result) {
		ModelAndView view = new ModelAndView("login");
		
		// If input bean does not have any validation error then proceed
		if(!result.hasFieldErrors()) {
			// If not a valid user then add error
			// else proceed to user welcome page
			if(!loginService.authenticateUser(userBean)) {
				return "Invalid Credentials";
			} else {	
				userBean = loginService.getUserList(userBean);
//				System.out.println(userBean.getFirstname()+" "+userBean.getLastname());
				return "Welcome "+userBean.getFirstname()+" "+userBean.getLastname();
				}
			
		}
		return "Try again!";
	}
	
}

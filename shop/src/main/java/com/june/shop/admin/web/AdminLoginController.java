package com.june.shop.admin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminLoginController {


	@RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
	public String printWelcomeUser() {
		return "hello";
	}

	@RequestMapping(value = "/admin/welcome", method = RequestMethod.GET)
	public String printWelcomeAdmin() {
		return "admin";
	}

	@RequestMapping(value = "/admin/loginAdmin", method = RequestMethod.GET)
	public String getLoginPage(
			Model model,
			HttpServletRequest request) {
		/*Login logininfo = (Login) request.getSession()
				.getAttribute("loginInfo");
		if(logininfo != null){
			return "redirect:/main";
		}*/
		//model.addAttribute("fail", fail);
		return "admin/login/loginAdmin";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return "hello";
	}
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String getFailurePage(Model model) {
		return "login/failure";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogoutPage(Model model, HttpServletRequest req) {
		req.getSession().invalidate();
		return "logout";
	}

}

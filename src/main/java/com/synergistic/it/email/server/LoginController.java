package com.synergistic.it.email.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.service.CustomerService;
import com.synergistic.it.util.DESedeEncryption;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String showLoginPage() {
		return SpringMvcNavigationCont.LOGIN_PAGE;
	}

	// http://localhost:9696/synergistic-mail-server/customer/addCustomer

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String postLoginPage(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		try {
			DESedeEncryption deSedeEncryption = new DESedeEncryption();
			password = deSedeEncryption.encrypt(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = customerService.authUser(username, password);
		if (result.equals("failure")) {
			session.setAttribute("error", "Invalid User name or Password!");
			return SpringMvcNavigationCont.LOGIN_PAGE;
		} else {
			session.removeAttribute("error");
			session.setAttribute("userName", username);
			List<FolderForm> folderForms = customerService.findallfolders(username);
			session.setAttribute("folders", folderForms);
			return SpringMvcNavigationCont.USER_HOME;
		}
	}
}

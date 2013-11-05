package com.synergistic.it.email.server;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergistic.it.constant.EMailServerConstant;
import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.server.listener.UserSessionVO;
import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.service.CustomerService;
import com.synergistic.it.service.FolderService;
import com.synergistic.it.util.DESedeEncryption;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	@Autowired
	@Qualifier("FolderServiceImpl")
	private FolderService folderService;
	
	
	@RequestMapping(value = "availableUsers.htm", method = RequestMethod.GET)
	public @ResponseBody String availableUsers(HttpSession session){
			Set<UserSessionVO> logins = (Set<UserSessionVO>) session.getServletContext().getAttribute("logins");
			StringBuilder builder=new StringBuilder();
			for(UserSessionVO userSessionVO:logins){
				builder.append(userSessionVO.getFirstName()+":"+userSessionVO.getUserid()+",");	
			}
			return builder.toString();
	 }
		
	
	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String showLoginPage() {
		return SpringMvcNavigationCont.LOGIN_PAGE;
	}

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "sessionTimeOut.htm", method = RequestMethod.GET)
	public String sessionTimeOut(Model model) {
		model.addAttribute("error", "Your session is time out, please log in once again");
		return SpringMvcNavigationCont.SESSION_TIME_OUT;
	}
	
	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return SpringMvcNavigationCont.LOGIN_PAGE;
	}

	// http://localhost:9696/synergistic-mail-server/customer/addCustomer

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String postLoginPage(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session,Model model) {
		try {
			DESedeEncryption deSedeEncryption = new DESedeEncryption();
			password = deSedeEncryption.encrypt(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CustomerForm customerForm = customerService.authUser(username, password);
		if (customerForm==null) {
			//session.setAttribute("error", "Invalid User name or Password!");
			model.addAttribute("error", "Invalid User name or Password!");
			return SpringMvcNavigationCont.LOGIN_PAGE;
		} else {
			//session.removeAttribute("error");
			//creating an object UserLoginVO
			UserSessionVO userSessionVO=new UserSessionVO();
			userSessionVO.setUserid(username);
			userSessionVO.setFirstName(customerForm.getFirstName());
			userSessionVO.setPassword(password);
			//adding session VO in session scope
			session.setAttribute(EMailServerConstant.USER_SESSION_VO, userSessionVO);
			
			session.setAttribute(SpringMvcNavigationCont.USER_ID, username);
			session.setAttribute(SpringMvcNavigationCont.USER_PASSWORD, password);
			List<FolderForm> folderForms = folderService.findallfolders(username);
			//this code is comment since I am fetching CustomerForm data when user is authenticated from the db
			//CustomerForm customerForm = customerService.findUserById(username);
			model.addAttribute("customerform",customerForm);
			session.setAttribute("folderForms",folderForms);
			return SpringMvcNavigationCont.USER_HOME;
		}
	}
	@RequestMapping(value = "loadImageById.htm", method = RequestMethod.GET)
	public void loadImageById(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter("userid");
		// System.out.println("ALBUM ID IS:" +albumId);
		byte[] byteArray = customerService.findImageByUserId(userid);
		response.setContentType("image/jpeg");
		response.setContentType("image/png");
		try {
			ServletOutputStream out = response.getOutputStream();
			out.write(byteArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

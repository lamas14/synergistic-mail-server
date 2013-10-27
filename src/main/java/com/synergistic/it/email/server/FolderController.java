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

@Controller
@RequestMapping("/auth")
public class FolderController {

	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;

	
	@RequestMapping(value = "addFolder.htm", method = RequestMethod.POST)
	private String addFolder(@RequestParam("folderName") String folderName, HttpSession session) {
		String userName = (String) session.getAttribute("userName");
		boolean result = customerService.addFolder(userName, folderName);
		if(!result){
			session.setAttribute("message", "Folder already exists");
			return SpringMvcNavigationCont.USER_HOME;
		}else {
			session.setAttribute("message", "Folder added successfully");
			List<FolderForm> folderForms = customerService.findallfolders(userName);
			session.setAttribute("folders", folderForms);
			return SpringMvcNavigationCont.USER_HOME;
		}
	}
}

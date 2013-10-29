package com.synergistic.it.email.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	@Qualifier("FolderServiceImpl")
	private FolderService folderService;

	@RequestMapping(value = "addFolder.htm", method = RequestMethod.POST)
	private String addFolder(@RequestParam("folderName") String folderName, HttpSession session,Model model) {
		String userName = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
		boolean result = folderService.addFolder(userName, folderName);
		if(!result){
			model.addAttribute("message", "Folder already exists");
			return SpringMvcNavigationCont.USER_HOME;
		}else {
			model.addAttribute("message", "Folder added successfully");
			List<FolderForm> folderForms = folderService.findallfolders(userName);
			session.setAttribute("folderForms", folderForms);
			return SpringMvcNavigationCont.USER_HOME;
		}
	}
}

package com.synergistic.it.email.server;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.EmailForm;
import com.synergistic.it.service.CustomerService;
import com.synergistic.it.service.EmailService;
import com.synergistic.it.util.DateUtils;


/**
 * 
 * @author ajit
 *    This class is used to send email to the users
 *
 */
@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	@Qualifier("EmailServiceImpl")
	private EmailService emailService;
	

	/**
	 * 
	 * @param sentEmailForm 
	 * @param session this scope
	 * @return
	 */
	@RequestMapping(value = "sentEmail.htm", method = RequestMethod.POST)
	public String upSentEmails(
			@ModelAttribute("sentEmailForm") EmailForm emailForm,
			HttpSession session) {
		String userid = session.getAttribute(SpringMvcNavigationCont.USER_ID).toString();
		emailForm.setMAILFROM(userid);
		emailForm.setMAILDATE(DateUtils.getCurrentDateInSQLFormat());
		emailForm.setFOLDER("Inbox");
		session.setAttribute("sentEmailForm", emailForm);
		emailService.uploadSentEmail(emailForm);
		return SpringMvcNavigationCont.USER_HOME;
	}
	
	@RequestMapping(value="showEmails.htm", method = RequestMethod.GET)
	public String showEmails(@RequestParam("folderName")String folderName, HttpSession session, Model model){
		String userid = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
		List<EmailForm>	emailForms = emailService.getEmails(userid, folderName);
		model.addAttribute("emailForms", emailForms);
		return SpringMvcNavigationCont.SHOW_EMAILS;
	}
	
	@RequestMapping(value="moveEmails.htm", method = RequestMethod.POST)
	public String moveEmails(@RequestParam("destFolder") String destFolder, HttpServletRequest request){
		String[] selectedMails = request.getParameterValues("selectedMails");
		emailService.moveEmail(destFolder, selectedMails);
		return SpringMvcNavigationCont.USER_HOME;
	}

}

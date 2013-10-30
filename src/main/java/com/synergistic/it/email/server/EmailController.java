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
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.service.EmailService;
import com.synergistic.it.util.DateUtils;

/**
 * 
 * @author ajit This class is used to send email to the users
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
	 * @param session
	 *            this scope
	 * @return
	 */
	@RequestMapping(value = "sentEmail.htm", method = RequestMethod.POST)
	public String upSentEmails(
			@ModelAttribute("sentEmailForm") EmailForm emailForm,
			HttpSession session) {
		String userid = session.getAttribute(SpringMvcNavigationCont.USER_ID)
				.toString();
		emailForm.setMAILFROM(userid);
		emailForm.setMAILDATE(DateUtils.getCurrentDateInSQLFormat());
		emailForm.setFOLDER("Inbox");
		session.setAttribute("sentEmailForm", emailForm);
		emailService.uploadSentEmail(emailForm);
		return SpringMvcNavigationCont.USER_HOME;
	}

	@RequestMapping(value = "showEmails.htm", method = RequestMethod.GET)
	public String showEmails(@RequestParam("folderName") String folderName,
			HttpSession session, Model model) {
		String userid = (String) session
				.getAttribute(SpringMvcNavigationCont.USER_ID);
		List<EmailForm> emailForms = emailService.getEmails(userid, folderName);
		model.addAttribute("emailForms", emailForms);
		return SpringMvcNavigationCont.SHOW_EMAILS;
	}

	@RequestMapping(value = "updateEmails.htm", method = RequestMethod.POST)
	public String moveEmails(@RequestParam("destFolder") String destFolder,
			Model model, HttpServletRequest request, HttpSession session) {
		String[] selectedMails = request.getParameterValues("selectedMails");
		String actionName=request.getParameter("actionName");
		String userid = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
		if ("delete".equalsIgnoreCase(actionName)) {
			if (selectedMails == null) {
				model.addAttribute("error", "No emails were selected to delete");
				return SpringMvcNavigationCont.USER_HOME;
			}
			emailService.deleteEmail(selectedMails, userid);
			model.addAttribute("message", "Emails deleted");
		}
		if ("move".equalsIgnoreCase(actionName)) {
			if (selectedMails == null) {
				model.addAttribute("error",
						"No emails were selected to move to " + destFolder);
				return SpringMvcNavigationCont.USER_HOME;
			}
			model.addAttribute("message", "Emails moved to " + destFolder);
			emailService.moveEmail(destFolder, selectedMails, userid);
		}
		return SpringMvcNavigationCont.USER_HOME;
	}

	@RequestMapping(value = "showMessage.htm", method = RequestMethod.GET)
	public String showMessage(HttpServletRequest request, Model model, HttpSession session) {
		String userid = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
		int MAILID = Integer.parseInt(request.getParameter("MAILID"));
		EmailEntity emailEntity = emailService.getEmailEntity(MAILID, userid);
		model.addAttribute("emailContent", emailEntity);
		return SpringMvcNavigationCont.SHOW_MESSAGE;
	}

}

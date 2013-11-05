package com.synergistic.it.email.server;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.ChatForm;
import com.synergistic.it.hibernate.entity.ChatEntityHistory;
import com.synergistic.it.service.ChatService;

@Controller
@RequestMapping("/chat")
public class UserChatController {

	@Autowired
	@Qualifier("ChatServiceImpl")
	private ChatService chatService;

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "checkMessage.htm", method = RequestMethod.GET)
	public @ResponseBody
	ChatForm checkMessage(@RequestParam("userid") String userid) {
		ChatForm chatForm = chatService.findChatMessageByUserId(userid);
		// @ResponseBody this annotation by pass view resolver and writes java
		// object data into body of response directly
		return chatForm;
	}

	// this page is called when we are displaying our initial registration form
	@RequestMapping(value = "sendChatMessage.htm", method = RequestMethod.GET)
	public @ResponseBody
	String sendChatMessage(@RequestParam("touserid") String touserid,
			@RequestParam("fcm") String fcm, HttpSession session) {
		String fromuserid = (String) session
				.getAttribute(SpringMvcNavigationCont.USER_ID);
		ChatForm chatForm = new ChatForm();
		chatForm.setFromuser(fromuserid);
		chatForm.setTouser(touserid);
		chatForm.setMsg(fcm);
		chatForm.setCdate(new Date());
		chatService.pushMessageByUserId(chatForm);
		return "sent";
	}

	// This page is called when we are displaying chat history
	@RequestMapping(value = "chatList.htm", method = RequestMethod.GET)
	public String chatList(HttpSession session, Model model) {
		String userid = (String) session
				.getAttribute(SpringMvcNavigationCont.USER_ID);

		// Get date and list of people you chatted with
		List<ChatEntityHistory> chatUserList = chatService.chatList(userid);
		model.addAttribute("chatUserList", chatUserList);
		return SpringMvcNavigationCont.CHAT_HISTORY_LIST;
	}

	@RequestMapping(value = "showHistory.htm", method = RequestMethod.GET)
	public String showHistory(@RequestParam("userid1") String ui1,
			@RequestParam("userid2") String ui2, Model model) {

		// Get date and list of people you chatted with
		List<ChatEntityHistory> chatHistory = chatService.showHistory(ui1, ui2);
		model.addAttribute("chatHistory", chatHistory);
		return SpringMvcNavigationCont.SHOW_HISTORY;
	}

}

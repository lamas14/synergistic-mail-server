package com.synergistic.it.email.server;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.service.CustomerService;
import com.synergistic.it.util.DESedeEncryption;
import com.synergistic.it.util.DateUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	//this page is called when we are displaying our initial registration form
	@RequestMapping(value="userHome.htm",method=RequestMethod.GET)
	public String showHomePage(){
		return "userHome";
	}
	
	//http://localhost:9696/synergistic-mail-server/customer/addCustomer
	
	//this page is called when we are displaying our initial registration form
	@RequestMapping(value="addCustomer.htm",method=RequestMethod.GET)
	public String showCustomerPage(Model model){
		CustomerForm customerForm=new CustomerForm();
		//model is hashmap which carry data from spring controller to the UI page
		model.addAttribute("fcustomerForm", customerForm);
		return SpringMvcNavigationCont.USER_REGISTRATION_PAGE;
	}
	
	
	//this method is called on form submission
	@RequestMapping(value="addCustomer.htm",method=RequestMethod.POST)
	public String uploadCustomer(@ModelAttribute("fcustomerForm") CustomerForm customerForm,HttpSession session){
		System.out.println(customerForm);
		customerForm.setDoe(DateUtils.getCurrentDateInSQLFormat());
		customerForm.setDom(DateUtils.getCurrentDateInSQLFormat());
		session.setAttribute("fcustomerForm", customerForm);
		return SpringMvcNavigationCont.UPLOAD_IMAGE_PAGE;
	}
	
	
	//this method is called on form submission
	@RequestMapping(value="uploadImage.htm",method=RequestMethod.POST)
	public String uploadImageCustomer(@RequestParam(value="photo",required=false) MultipartFile photo,HttpSession session){
		CustomerForm customerForm=(CustomerForm)session.getAttribute("fcustomerForm");
		byte[] pphoto=null;
		try {
			 pphoto=photo.getBytes();
			 //encrypting the password
			 DESedeEncryption deSedeEncryption=new DESedeEncryption();
			customerForm.setPassword(deSedeEncryption.encrypt(customerForm.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("fcustomerForm");
		String imageName=photo.getOriginalFilename();
		customerForm.setImageName(imageName);
		customerForm.setPhoto(pphoto);
		//calling business layer
		
		customerService.uploadCustomer(customerForm);
		return SpringMvcNavigationCont.LOGIN_PAGE;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}
	

}

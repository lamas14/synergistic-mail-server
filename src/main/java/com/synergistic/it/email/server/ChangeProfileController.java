package com.synergistic.it.email.server;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.synergistic.it.constant.EMailServerConstant;
import com.synergistic.it.constant.SpringMvcNavigationCont;
import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.service.CustomerService;
import com.synergistic.it.util.DESedeEncryption;

@Controller
@RequestMapping("/auth")
public class ChangeProfileController {
	
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	
	//this page is called when we are displaying our initial registration form
		@RequestMapping(value="changepwd.htm",method=RequestMethod.GET)
		public String preChangePwdPage(){
			return SpringMvcNavigationCont.LOGIN_PAGE;
		}
		
		@RequestMapping(value="changepwd.htm",method=RequestMethod.POST)
		public String postChangePwdPage(@RequestParam("newpassword") String newpassword,HttpSession session){
			
			String userid = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
			CustomerForm customerForm = customerService.findUserById(userid);
			try {
				DESedeEncryption deSedeEncryption=new DESedeEncryption();
				newpassword=deSedeEncryption.encrypt(newpassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			customerForm.setPassword(newpassword);
			String result = customerService.saveCustomer(customerForm);
			if (result.equals(EMailServerConstant.SUCCESS)){
				try {
					DESedeEncryption deSedeEncryption=new DESedeEncryption();
					deSedeEncryption = new DESedeEncryption();
					newpassword = deSedeEncryption.decrypt(newpassword);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				session.setAttribute(SpringMvcNavigationCont.USER_PASSWORD, newpassword);
			}
			return SpringMvcNavigationCont.USER_HOME;
		}
		
		//this page is called when we are displaying our initial registration form
				@RequestMapping(value="changeProfile.htm",method=RequestMethod.GET)
				public String preChangeProfilePage(){
					return SpringMvcNavigationCont.LOGIN_PAGE;
				}
				
				@RequestMapping(value="changeprofile.htm",method=RequestMethod.POST)
				public String postChangeProfilePage(@RequestParam("phone") String phone,@RequestParam("location") String location,@RequestParam("address") String address,@RequestParam(value="photo",required=false) MultipartFile photo,HttpSession session, Model model){
					String userid = (String) session.getAttribute(SpringMvcNavigationCont.USER_ID);
					CustomerForm customerForm = customerService.findUserById(userid);
					byte[] pphoto=null;
					try {
						 pphoto=photo.getBytes();
						} catch (Exception e) {
						e.printStackTrace();
					}
					if (photo != null){
						String imageName=photo.getOriginalFilename();
						customerForm.setImageName(imageName);
						customerForm.setPhoto(pphoto);
					}
					customerForm.setPhone(phone);
					customerForm.setLocation(location);
					customerForm.setAddress(address);
					
					String result = customerService.saveCustomer(customerForm);
					if (result.equals(EMailServerConstant.SUCCESS)){
						model.addAttribute("customerform",customerForm);
						return SpringMvcNavigationCont.USER_HOME;
					}
					return SpringMvcNavigationCont.USER_HOME;
				}
}

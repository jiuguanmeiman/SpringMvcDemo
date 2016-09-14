package wenzhong.springmvc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import wenzhong.springmvc.model.User;
import wenzhong.springmvc.service.IUserService;

@Controller
@SessionAttributes("loginUser")//httpSession注入
public class IndexController {

	IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserSercive(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password,Model model){//可以在这里注入sessionAttribute,存熟悉
		User u=userService.login(username, password);
		model.addAttribute("loginUser",u);//写入属性，上面的注入就写入了httpSession中了
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model,HttpSession session){
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/login";
	}
}

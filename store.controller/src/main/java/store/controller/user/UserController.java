package store.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import store.controller.ViewModel;
import store.model.user.User;


@Controller
@RequestMapping("/user")
public class UserController {
	
	protected final String loginPage = "users/login";
	
	@RequestMapping("/login")
	public ModelAndView getLoginPage(HttpServletRequest request) {

		return new ViewModel(loginPage, request);
		
	}
	
	@RequestMapping(value="/login/submit", method = RequestMethod.POST)
	public ModelAndView doLogin(User user) {

		ViewModel mv = null;
		
		return null;
	}
	
	@RequestMapping("/data/{pageID}")
	public @ResponseBody Object getProduct( @PathVariable(value="pageID") String id, 
	                                 @RequestParam String userId, HttpServletRequest request ) {
		ViewModel mv = null;
		
		return mv;
	}
	
	
	
}

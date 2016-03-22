package store.controller.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import store.controller.HomeController;
import store.controller.ViewModel;
import store.model.user.User;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDetailsService users;
	
	protected final String loginPage = "users/login";
	
	@RequestMapping
	public ViewModel redirectToAccount(HttpServletRequest request) {
		return new ViewModel(loginPage , request);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		return new ViewModel(loginPage, request);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ViewModel doLogin(User user) {
		
		User u = (User) users.loadUserByUsername(user.getUsername());
		if(u != null){
			//Object ad = u.getAddresses().get(0);
			if(u.getPassword().equals(user.getPassword()))
				return new ViewModel("redirect:" + HomeController.indexPage, null);
		}
		return null;
	}
	
	@RequestMapping(value="/account")
	public ViewModel getAccountManagement(HttpServletRequest request) {
		return new ViewModel(HomeController.indexPage, request);
	}
	
	@RequestMapping("/data/{pageID}")
	public @ResponseBody Object getProduct( @PathVariable(value="pageID") String id, 
	                                 @RequestParam String userId, HttpServletRequest request ) {
		ViewModel mv = null;
		
		return mv;
	}
	
	
	
}

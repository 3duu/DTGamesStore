package store.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import store.model.user.User;


@Transactional
@Controller
@RequestMapping("/login")
public class UserController {
	
	protected final String loginPage = "user/login";
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView doLogin(User user) {

		ModelAndView mv = null;
		if(user != null){
			mv = new ModelAndView(loginPage);
		}
		
		return mv;
	}
	
}

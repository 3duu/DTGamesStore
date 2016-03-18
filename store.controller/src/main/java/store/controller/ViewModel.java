package store.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class ViewModel extends ModelAndView{
	public ViewModel(String viewName, HttpServletRequest request){
		this.setViewName(viewName);
		this.addObject("urlBase", request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()));
	}
}

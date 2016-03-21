package store.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class ViewModel extends ModelAndView{
	public ViewModel(String viewName, HttpServletRequest request){
		this.setViewName(viewName);
		if(request != null)
			this.addObject("urlBase", request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()));
		try {
			throw new Exception("Url base não pode ser montada!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

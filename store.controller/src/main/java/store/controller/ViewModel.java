package store.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class ViewModel extends ModelAndView{
	public ViewModel(String viewName, HttpServletRequest request){
		this.setViewName(viewName);
		
		try {
			if(request != null)
				this.addObject("urlBase", request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new Exception("Url base não pode ser montada!");
		}
	}
}

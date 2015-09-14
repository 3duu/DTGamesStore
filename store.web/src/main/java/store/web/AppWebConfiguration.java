package store.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import store.controller.HomeController;


@EnableWebMvc
@ComponentScan(basePackageClasses =
{
	HomeController.class
})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = 
		new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setContentType(ViewConstants.MEDIA_TYPE_HTML);
		return resolver;
	}
	
//	@Bean
//	public FreeMarkerViewResolver freeMarkerViewResolver() {
//	    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
//	    viewResolver.setCache(true);
//	    viewResolver.setPrefix("");
//	    viewResolver.setSuffix(".html");
//	    viewResolver.setContentType(ViewConstants.MEDIA_TYPE_HTML);
//	    viewResolver.setRequestContextAttribute("request");
//	    viewResolver.setExposeSpringMacroHelpers(true);
//	    viewResolver.setExposeRequestAttributes(true);
//	    viewResolver.setExposeSessionAttributes(true);
//	    viewResolver.setOrder(2);
//	    return viewResolver;
//	}
	
}

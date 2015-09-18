package store.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import store.controller.*;
import store.infrastructure.dao.product.ProductDAO;


@EnableWebMvc
@ComponentScan(basePackageClasses =
{
	//Controllers
	HomeController.class,
	ProductController.class,
	
	//DAOs
	ProductDAO.class,
})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = 
		new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setContentType(ViewConstants.MEDIA_TYPE_HTML);
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(
		DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}

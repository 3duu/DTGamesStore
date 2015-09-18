package store.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import store.infrastructure.JPAConfiguration;


public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
					SecurityConfiguration.class
				};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{
					AppWebConfiguration.class,
					JPAConfiguration.class
				};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}


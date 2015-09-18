package store.web;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//	http
//		.httpBasic()
//			.and()
//				.authorizeRequests()
//					.antMatchers("/products/mostsold").permitAll()
//					//.antMatchers(HttpMethod.GET,"/").permitAll()
//					.antMatchers(HttpMethod.POST, "/user").permitAll();
		
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().and()
		.httpBasic();
	
		//.hasRole("ADMIN")
		//.anyRequest().authenticated()
		//.and()
		//.formLogin().loginPage("/login").permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/resources/**", "/js/**", "/css/**");
	}
	
}

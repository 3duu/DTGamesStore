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
	http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/products/mostsold").permitAll()
					.antMatchers(HttpMethod.GET,"/").permitAll();
	
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

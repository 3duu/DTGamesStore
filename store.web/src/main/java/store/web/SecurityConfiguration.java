package store.web;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private UserDetailsService users;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(users).
		passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.httpBasic()
				.and()
					.authorizeRequests()
						.antMatchers("/products/**").permitAll()
						.antMatchers("/shooping/**").permitAll()
						.antMatchers(HttpMethod.POST, "/user/login/submit").permitAll()
						.antMatchers("/user/login").permitAll()
						.antMatchers("/manage/**").hasRole("ADMIN");
		
//		http.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().and()
//		.httpBasic();
	
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

package store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService users;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		if(users == null)
//			return;
		auth.userDetailsService(users).
		passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.httpBasic()
			.and()//.csrf().disable()
					.authorizeRequests()
						.antMatchers("/products/**").permitAll()
						.antMatchers("/shooping/**").permitAll()
						.antMatchers("/users/**").permitAll()
						.antMatchers(HttpMethod.POST, "/products/**").denyAll()
						.antMatchers(HttpMethod.POST, "/shooping/**").permitAll()
						.antMatchers(HttpMethod.GET, "/user/**").permitAll()
						.antMatchers("/user/account/**").authenticated()
						.antMatchers("/manage/**").hasRole("ADMIN")
						.and().formLogin().loginPage("/user/login").permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/resources/**", "/js/**", "/css/**");
	}
	
	
	
}

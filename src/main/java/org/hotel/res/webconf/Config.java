package org.hotel.res.webconf;

import javax.annotation.Resource;

import org.hotel.res.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configurable
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200"); // allow angular server cors
	        }
	    };
	}
	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**")
	            .addResourceLocations("/resources/", "file:resources/");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()// disable cors 'Cros origine resources share'
		.authorizeRequests() // link without autorization
		.antMatchers(
				"/hotels","/hotel/*", "/resources/**", "/tmp/**", "/users/userEmail/*",
				"/reservation" , "/getListReservations" , "/reservation/?id=*" , "/users/add").permitAll().
		anyRequest().fullyAuthenticated().and().httpBasic()// URI needs basic authetication
		.and().csrf().disable();// disable Cross-Site Request Forgery (CSRF) is an attack that forces an end user to execute unwanted actions on a web application in which they're currently authenticated
	}
	@Autowired
	public void configHttpBasicRole(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
}
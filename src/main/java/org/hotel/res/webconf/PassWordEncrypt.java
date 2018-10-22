package org.hotel.res.webconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class PassWordEncrypt extends WebMvcConfigurerAdapter{


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder () {
	
		return new BCryptPasswordEncoder();
	}

}

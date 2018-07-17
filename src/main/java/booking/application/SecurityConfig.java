package booking.application;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT `email`,`passwordHash`,`active` FROM `users` WHERE `email`=?")
		.authoritiesByUsernameQuery("SELECT 'USER' FROM `users` WHERE `email`=?")
		.passwordEncoder(passwordEncoder());
	}
	
	 @Bean
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		 return new BCryptPasswordEncoder();
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .anyRequest()
	                    .denyAll()
	                .and()
	            .formLogin()
	                .disable();
	}
}

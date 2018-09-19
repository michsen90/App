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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	DataSource dataSource;
	
	/*
	 * 
	 * auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	 */
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//        .withUser("login").password("haslo")
//        .roles("USER");

		/*auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select login as username, password, 1 as enabled from accounts where login=?")
			.authoritiesByUsernameQuery("select login as username, 'USER' as role from accounts where login=?");*/
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select login as username, password, 1 as enabled from accounts where login=?")
		.authoritiesByUsernameQuery("select role, login from roles where login=?");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
              .antMatchers("/logowanie*", "/aktualnosci*", "/cennik*", 
        "/galeria*", "/kontakt*", "/onas", "/rejestracja*", "/js/**", "/index*", "/js/postrequest*", "/styles.css").permitAll()
              .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
          .and().httpBasic().and()
          .formLogin()
          .loginPage("/logowanie.html")
                .loginProcessingUrl("/verifyLogin")
          .defaultSuccessUrl("/index.html")
          .failureUrl("/logowanie.html?error=true")
          .and()
          .logout().logoutSuccessUrl("/logowanie.html");

        http.csrf().disable();
    }
  
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

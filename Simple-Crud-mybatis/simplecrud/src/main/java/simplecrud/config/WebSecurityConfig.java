package simplecrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import simplecrud.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired
 private UserDetailsServiceImpl udsi;
  @Override
    protected void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests()
  .antMatchers("/", "/index")
         .permitAll()
         .anyRequest()
//         .hasRole("ADMIN")
            .authenticated()
 .and()
  .formLogin()
    .loginPage("/login")
//         .successForwardUrl("/managerView")
         .successHandler(myAuthenticationSuccessHandler())
            .permitAll()
 .and()
  .logout()
    .permitAll();
  }


 @Bean
 @Primary
 public PasswordEncoder getPasswordEncoder() {
  return new BCryptPasswordEncoder();
 }
 @Bean
 public DaoAuthenticationProvider authenticationProvider(){
  DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
  auth.setUserDetailsService(udsi);
  auth.setPasswordEncoder(getPasswordEncoder());
  return auth;
 }
 @Bean
 public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
  return new MySimpleUrlAuthenticationSuccessHandler();
 }
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.authenticationProvider(authenticationProvider());
 }
}

package com.example.springsecurityexample.demo.config;

import com.example.springsecurityexample.demo.service.GroupUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

 /*   @Autowired
    private UserDetailsService userDetailsService;*/

 @Autowired
 private GroupUserDetailsService groupUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("monir").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user1").password("monir1").roles("USER");
//        auth.userDetailsService(userDetailsService);
        auth.userDetailsService(groupUserDetailsService);
    }

    //security for all API
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
    }*/

    //security based on url
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/rest/auth/**").fullyAuthenticated().and().httpBasic();
    }*/

  //SECURITY based on role

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/rest/auth/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
        http.authorizeRequests().antMatchers("/user/join").permitAll().and().authorizeRequests()
                .antMatchers("/user/**","/post/**").authenticated().and().httpBasic();
    }

    /*@Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

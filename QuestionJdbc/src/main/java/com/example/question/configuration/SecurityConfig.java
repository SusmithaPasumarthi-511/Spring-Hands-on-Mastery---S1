//package com.example.question.configuration;
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity security) throws Exception {
//        security.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
//        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);    
//    }
//
//}
//
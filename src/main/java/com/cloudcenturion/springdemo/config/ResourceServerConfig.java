package com.cloudcenturion.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
//@Order(1)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/rest/**").authorizeRequests()
                .antMatchers(HttpMethod.POST,"/rest/customer").access("#oauth2.hasScope('write') or #oauth2.hasScope('trusted')")
                .antMatchers("/rest/**").access("#oauth2.hasScope('read') or #oauth2.hasScope('write') or #oauth2.hasScope('trusted')")
                .and()
                .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}

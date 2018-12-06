package com.cloudcenturion.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients ) throws Exception{
        clients.inMemory().withClient("mailmonkey").authorizedGrantTypes("authorization_code")
                .authorities("CLIENT")
                .scopes("read","write")
                .secret("somesecretkey")
                .and()
                .withClient("trusted")
                .authorizedGrantTypes("client_credentials")
                .authorities("TRUSTED")
                .scopes("trusted")
                .secret("trustedsecret");
    }
}

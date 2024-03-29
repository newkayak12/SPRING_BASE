package com.server.base.components.configure.security.jwt;

import com.server.base.components.configure.ConfigMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "JwtSecurityConfig")
@DependsOn(value = {"JwtFilter"})
@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtFilter jwtFilter;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        builder.addFilterBefore(jwtFilter,  UsernamePasswordAuthenticationFilter.class);
    }

    @PostConstruct
    public void enabled(){
        ConfigMsg.msg("JwtSecurityConfig");
    }
}

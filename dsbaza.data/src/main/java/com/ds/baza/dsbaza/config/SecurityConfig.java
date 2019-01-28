package com.ds.baza.dsbaza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //ovaj bean sam dodao da ne bi bilo encode-ovanja passworda
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderTest();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //ovo {noop} znaci da prihvati password u formatu koji nije encodeovan
//        auth.inMemoryAuthentication().withUser("user@example.com").password("{noop}password").roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/login").permitAll()
                //.and().authorizeRequests().antMatchers(HttpMethod.GET, "/**").permitAll()
                .and().authorizeRequests().antMatchers("/signup", "forgot-password", "reset-password/*").permitAll()
                .and().authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().logout().permitAll()
                //za redirectovanje nakon uspesnog logina
                .and().formLogin().defaultSuccessUrl("/index", true);
                //ovo dodajem za remember me:
                //.and().rememberMe().key("topSecret").rememberMeServices(new TokenBasedRememberMeServices(rememberMeKey, userDetailsService));
    }
}

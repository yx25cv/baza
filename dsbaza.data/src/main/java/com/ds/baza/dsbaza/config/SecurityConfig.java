package com.ds.baza.dsbaza.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private String rememberMeKey;

    public SecurityConfig(@Qualifier("userDetails") UserDetailsService userDetailsService, @Value("${rememberMeKey}") String rememberMeKey) {
        this.userDetailsService = userDetailsService;
        this.rememberMeKey = rememberMeKey;
    }

    //ovaj bean sam dodao da ne bi bilo encode-ovanja passworda
    @Bean
    public PasswordEncoder passwordEncoder(){
        //ovaj deo sam zakomentarisao
        //return new PasswordEncoderTest();
        return new BCryptPasswordEncoder();
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
                .and().authorizeRequests().antMatchers("forgot-password", "reset-password/*").permitAll()
                .and().authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .and().authorizeRequests().antMatchers("/admin/**", "/signup").hasRole("ADMIN")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().logout().permitAll()
                //za redirectovanje nakon uspesnog logina
                .and().formLogin().defaultSuccessUrl("/index", true)
//                .and().exceptionHandling().accessDeniedPage("/403");
                //ovo dodajem za remember me:
                .and().rememberMe().key(rememberMeKey).rememberMeServices(new TokenBasedRememberMeServices(rememberMeKey, userDetailsService));
    }
}

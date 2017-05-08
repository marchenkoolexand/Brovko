package com.brovko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest()
                .authenticated();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
        http.formLogin()
                .loginPage("/login")
                .permitAll();
        http.exceptionHandling()
                .accessDeniedPage("/error?error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

}

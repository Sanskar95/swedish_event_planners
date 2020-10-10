//package com.kth.sep.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    private UserPrincipalDetailsService userPrincipalDetailsService;
//
//    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
//        this.userPrincipalDetailsService = userPrincipalDetailsService;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser("namhm")
//                .password("hello")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("hello")
//                .roles("ADMIN")
//        ;
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
//
////    @Bean
////    DaoAuthenticationProvider authenticationProvider(){
////        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
////
////        return daoAuthenticationProvider;
////    }
////
////
////    @Bean
////    PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//}

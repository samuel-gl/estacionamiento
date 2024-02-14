package com.samuelgl.estacionamiento;

import com.samuelgl.estacionamiento.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@RequiredArgsConstructor
public class WebSecurity {


    @Autowired
    public UsuarioServicio usuarioServicio;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioServicio)
                .passwordEncoder(new BCryptPasswordEncoder());
    }




    @Bean //Equivalente a configure, request equivalente a antMatchers
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/js/**", "/images/**");
    }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth

                                .antMatchers(("/admin/*")).hasRole("ADMIN")
                                .antMatchers("/css/**", "/js/**").permitAll()
                                //.antMatchers("/register").permitAll()
                                .antMatchers("/login").permitAll()
                                .anyRequest().authenticated()

                )
                .formLogin( loginConfig ->
                        loginConfig
                                //.loginPage("/login")
                                //.loginProcessingUrl("/login")
                                .usernameParameter("nombreUsuario")
                                .passwordParameter("contrasena")
                                //.defaultSuccessUrl("/index",true) PENDIENTE ACTUALIZAR
                                .permitAll()
                )
                .logout( logoutConfig ->
                        logoutConfig
                                .deleteCookies("JSESSIONID")
                                //.logoutUrl("/logout") PENDIENTE ACTUALIZAR
                                //.logoutSuccessUrl("/login") PENDIENTE ACTUALIZAR
                                .permitAll()
                )
                .build();

    }


}

package ru.housemanagement.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.housemanagement.model.User;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        jdbcTemplate.query(
                "SELECT user, password FROM users",
                (rs, rowNum) -> new User(rs.getString("user"), rs.getString("password")))
                .forEach(user -> {
                    if (user.getName().equals("admin"))
                        try {
                            auth.inMemoryAuthentication().withUser(user.getName()).password(user.getPassword()).roles("ADMIN");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    else
                        try {
                            auth.inMemoryAuthentication().withUser(user.getName()).password(user.getPassword()).roles("USER");
                        }
                        catch (Exception e) {
                        e.printStackTrace();
                        }
                });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home", "/").hasAnyRole("ADMIN", "USER").anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/home", true).loginPage("/login").permitAll().and().logout()
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }

}
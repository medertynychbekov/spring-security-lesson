package main_package.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(
                        user.username("admin")
                                .password("admin")
                                .roles("ADMIN")
                )
                .withUser(user
                        .username("user")
                        .password("user")
                        .roles("USER")
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN", "USER")
                .antMatchers("/auth/user_endpoint").hasAnyRole("USER", "ADMIN")
                .antMatchers("/auth/admin_endpoint").hasRole("ADMIN")
                .and()
                .formLogin().permitAll();
    }
}

package ma.enset.patientsmvc.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user1").password("{noop}1234").roles("USER").build(),
            User.withUsername("user2").password("{noop}1234").roles("USER").build(),
            User.withUsername("admin").password("{noop}1234").roles("USER", "ADMIN").build()
        );
    }

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(formLogin->
            formLogin
                    .loginPage("/login")
                    .permitAll()
        );
        *//*httpSecurity.rememberMe();
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();*//*
        return httpSecurity.build();
    }*/

}

////////////////////////////////////////////////savoir//////////////////////////////////////////////////////////////

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("{noop}1234")
                        .roles("USER")
                        .build();
                User.withDefaultPasswordEncoder()
                        .username("user2")
                        .password("{noop}1234")
                        .roles("USER")
                        .build();
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("{noop}1234")
                        .roles("USER", "ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}*/

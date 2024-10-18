package sa.bupa.sadirbootstrap.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sa.bupa.sadirbootstrap.iam.domain.SdrRole;
import sa.bupa.sadirbootstrap.security.service.impl.SdrIdentityDetailServiceImpl;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@EnableMethodSecurity
public class SdrSecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, Set<SdrRole> roles,
                                         AuthenticationProvider appAuthenticationProvider) throws Exception {

        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated())
                .authenticationManager(new AuthenticationManager() {
                    @Override
                    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                        return appAuthenticationProvider.authenticate(authentication);
                    }
                })
                .authenticationProvider(appAuthenticationProvider)
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

       return http.build();
    }

    @Bean
    public AuthenticationProvider applicationAuthenticationProvider(SdrIdentityDetailServiceImpl service) {
        var provider= new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        return provider;
    }

}

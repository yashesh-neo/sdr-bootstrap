package sa.bupa.sadirbootstrap.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sa.bupa.sadirbootstrap.iam.domain.SdrRole;
import sa.bupa.sadirbootstrap.security.filter.SdrJwtAuthFilter;
import sa.bupa.sadirbootstrap.security.service.SdrUserCacheService;
import sa.bupa.sadirbootstrap.security.service.SdrUserDetailService;
import java.util.Set;


@Configuration
@EnableMethodSecurity
public class SdrSecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http,
                                         AuthenticationProvider appAuthenticationProvider,
                                         SdrJwtAuthFilter authFilter) throws Exception {

        http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authenticationManager(authentication -> appAuthenticationProvider.authenticate(authentication))
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

       return http.build();
    }

    @Bean
    public AuthenticationProvider applicationAuthenticationProvider(@Qualifier("SdrIdentityDbImpl") SdrUserDetailService service,
                                                                    @Qualifier("sdrIdentityInMemCache") SdrUserCacheService cacheService) {
        var provider= new DaoAuthenticationProvider();
            provider.setUserDetailsService(service);
            provider.setUserCache(cacheService);
        return provider;
    }

}

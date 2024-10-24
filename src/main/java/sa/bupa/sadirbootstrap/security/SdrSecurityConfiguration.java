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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import sa.bupa.sadirbootstrap.iam.domain.SdrRole;
import sa.bupa.sadirbootstrap.security.filter.SdrJwtAuthFilter;
import sa.bupa.sadirbootstrap.security.service.SdrUserCacheService;
import sa.bupa.sadirbootstrap.security.service.SdrUserDetailService;

import java.util.Arrays;
import java.util.Set;


@Configuration
@EnableMethodSecurity
public class SdrSecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http,
                                         AuthenticationProvider appAuthenticationProvider,
                                         SdrJwtAuthFilter authFilter) throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/actuator/**").permitAll()
                                .requestMatchers("/swagger-ui/**","/v3/**").permitAll()
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

    //Override Cors config to allow all origins
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

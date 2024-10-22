package sa.bupa.sadirbootstrap.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sa.bupa.sadirbootstrap.security.service.SdrUserDetailService;
import sa.bupa.sadirbootstrap.security.service.TokenMangerService;
import sa.bupa.sadirbootstrap.security.service.impl.SdrIdentityCacheServiceImpl;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SdrJwtAuthFilter extends OncePerRequestFilter {

    @Qualifier("JwtManagerService")
    private final TokenMangerService tokenService;
    @Qualifier("SdrIdentityDbImpl")
    private final SdrUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Retrieve the Authorization header
        var authHeader = request.getHeader("Authorization");
        String token = null;
        String principal = null;
        // Check if the header starts with "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7); // Extract token
            principal = tokenService.getPrincipal(token); // Extract username from token
        }

        // If the token is valid and no authentication is set in the context
        if (principal != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailService.loadUserByUsername(principal);

            // Validate token and set authentication
            if (tokenService.validateToken(token, userDetails)) {
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        (userDetails.getAuthorities()!=null?userDetails.getAuthorities():null)
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

}

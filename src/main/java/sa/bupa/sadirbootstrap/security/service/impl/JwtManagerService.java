package sa.bupa.sadirbootstrap.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.iam.domain.SdrAuthority;
import sa.bupa.sadirbootstrap.security.service.TokenMangerService;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Qualifier("JwtManagerService")
public class JwtManagerService implements TokenMangerService {
    @Value("${app-data.jwt-key}")
    public String SECRET;
    private static final String MODULES_KEY = "sdr_modules";

    @Override
    public String createToken(String username, Set<SdrAuthority> claims) {
         return Jwts.builder()
                 .claims(Map.of(MODULES_KEY,  claims.stream()
                                 .map(ath -> String.valueOf(ath.getModuleId()).concat(";").concat(ath.getAccessPattern()))
                                 .collect(Collectors.joining(","))))
                 .subject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Token valid for 60 minutes
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Get the signing key for JWT token
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getPrincipal(String token) {
        return extractPrincipal(token);
    }

    @Override
    public Set<SdrAuthority> getAuthorities(String token) {
        var moduleStr = extractClaim(token, claims -> claims.get(MODULES_KEY,String.class));
        return   Arrays.stream(moduleStr.split(",")).map(s -> {
            String[] components = s.split(";");
            var ath= new SdrAuthority();
            ath.setModuleId(Long.parseLong(components[0]));
            ath.setAccessPattern(components[1]);
            return ath;
        }).collect(Collectors.toSet());
    }


    // Extract a claim from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Check if the token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Validate the token against user details and expiration
    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractPrincipal(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Extract the username from the token
    public String extractPrincipal(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract the expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}

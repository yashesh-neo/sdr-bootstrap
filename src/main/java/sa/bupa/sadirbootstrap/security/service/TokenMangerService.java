package sa.bupa.sadirbootstrap.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import sa.bupa.sadirbootstrap.iam.domain.SdrAuthority;
import sa.bupa.sadirbootstrap.iam.domain.identities.impl.Customer;

import java.util.Collection;
import java.util.Set;

public interface TokenMangerService {
    String createToken(String username, Set<SdrAuthority> claims);
    String getPrincipal(String token);
    Set<SdrAuthority> getAuthorities(String token);
    boolean validateToken(String token, UserDetails user);
}

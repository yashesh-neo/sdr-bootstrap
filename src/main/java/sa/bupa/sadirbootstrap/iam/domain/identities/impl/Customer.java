package sa.bupa.sadirbootstrap.iam.domain.identities.impl;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sa.bupa.sadirbootstrap.iam.domain.SdrIdentity;
import java.util.Collection;


@Data
public class Customer extends SdrIdentity implements UserDetails {
    private String nationalUnifiedNumber;
    private String crNumber;
    private String contactEmail;
    private String contactMobile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole().getAuthorities()
                .stream()
                .map(am -> new SimpleGrantedAuthority(String.valueOf(am.getModuleId())
                        .concat(SEPARATOR_MODULE_PERMISSION)
                            .concat(am.getAccessPattern())))
                .toList();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return getPrincipal();
    }
}

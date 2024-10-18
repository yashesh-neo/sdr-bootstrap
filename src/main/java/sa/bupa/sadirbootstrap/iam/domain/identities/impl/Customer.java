package sa.bupa.sadirbootstrap.iam.domain.identities.impl;

import lombok.Data;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sa.bupa.sadirbootstrap.iam.domain.SdrIdentity;
import sa.bupa.sadirbootstrap.iam.mappings.IamMapper;

import java.util.Collection;
import java.util.List;

@Data
public class Customer extends SdrIdentity implements UserDetails {
    private String nationalUnifiedNumber;
    private String crNumber;
    private String contactEmail;
    private String contactMobile;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole().getAuthorities().stream().map(am ->{
            var authority= new SimpleGrantedAuthority(getRole().getAuthorities().stream().findFirst().get().getAccessPattern());
            return authority;
        }).toList();
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

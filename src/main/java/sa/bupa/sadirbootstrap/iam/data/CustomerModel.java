package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sa.bupa.sadirbootstrap.iam.mappings.IamMapper;

import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("BUPA_CUSTOMER")
@Getter
@Setter
public class CustomerModel extends SdrIdentityModel {
    private String nationalUnifiedNumber;
    private String crNumber;
    private String contactEmail;
    private String contactMobile;
}

package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("BUPA_CUSTOMER")
@Getter
@Setter
public class CustomerModel extends SdrIdentityModel{
    private String nationalUnifiedNumber;
    private String crNumber;
    private String contactEmail;
    private String contactMobile;
}

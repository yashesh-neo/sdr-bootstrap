package sa.bupa.sadirbootstrap.iam.domain.identities.impl;

import lombok.Data;
import sa.bupa.sadirbootstrap.iam.domain.SdrIdentity;

@Data
public class Customer extends SdrIdentity {
    private String nationalUnifiedNumber;
    private String crNumber;
    private String contactEmail;
    private String contactMobile;
}

package sa.bupa.sadirbootstrap.iam.domain.identities.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.bupa.sadirbootstrap.iam.domain.SdrIdentity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizedPerson extends SdrIdentity {
    private String authorizedId;
}

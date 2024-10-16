package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SDR_ROLES")
@Getter
@Setter
public class SdrRoleModel {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "role")
    private Set<SdrAuthoritiesModel> authorities;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, mappedBy = "assignedRole")
    private Set<SdrIdentityModel> identities;

}

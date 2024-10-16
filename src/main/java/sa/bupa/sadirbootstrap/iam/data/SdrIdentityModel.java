package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_IDENTITIES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Identity_Type")
@Getter
@Setter
public class SdrIdentityModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String principal;
    @ManyToOne(optional = false)
    private SdrRoleModel assignedRole;
}

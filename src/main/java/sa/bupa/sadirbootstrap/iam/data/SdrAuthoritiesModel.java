package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sa.bupa.sadirbootstrap.iam.data.enumrations.SdrModulePermissions;
import sa.bupa.sadirbootstrap.iam.domain.SdrRole;

@Entity
@Table(name = "SDR_AUTHORITIES")
@Getter
@Setter
public class SdrAuthoritiesModel {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SdrApplicationModuleModel module;
    @ManyToOne(fetch = FetchType.LAZY)
    private SdrRoleModel role;
    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private SdrModulePermissions create;
    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private SdrModulePermissions update;
    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private SdrModulePermissions delete;
    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private SdrModulePermissions read;

}

package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SDR_APPLICATION_MODULES")
@Getter
@Setter
public class SdrApplicationModuleModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private SdrApplicationModuleModel parent;

    @OneToMany(cascade = CascadeType.ALL,
               orphanRemoval = true,
                fetch = FetchType.LAZY
    )
    @JoinColumn(name = "parentId")
    private Set<SdrApplicationModuleModel> subModules;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<SdrAuthoritiesModel> authorities;
}

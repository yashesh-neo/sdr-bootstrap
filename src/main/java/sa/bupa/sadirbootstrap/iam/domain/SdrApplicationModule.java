package sa.bupa.sadirbootstrap.iam.domain;

import lombok.Data;

import java.util.Set;

@Data
public class SdrApplicationModule {
    private long id;
    private String name;
    Set<SdrApplicationModule> subModules;
}

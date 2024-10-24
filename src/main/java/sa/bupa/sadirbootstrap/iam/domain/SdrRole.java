package sa.bupa.sadirbootstrap.iam.domain;

import lombok.Data;

import java.util.Set;

@Data
public abstract class SdrRole {
    private long id;
    private String title;
    private Set<SdrAuthority> authorities;
}

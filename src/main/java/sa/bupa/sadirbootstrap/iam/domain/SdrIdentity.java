package sa.bupa.sadirbootstrap.iam.domain;

import lombok.Data;

@Data
public abstract class SdrIdentity {
    private long id;
    private String principal;
    private SdrRole role;
    public static final String SEPARATOR_MODULE_PERMISSION=";";
}

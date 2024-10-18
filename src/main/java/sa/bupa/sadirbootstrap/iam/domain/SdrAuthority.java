package sa.bupa.sadirbootstrap.iam.domain;

import lombok.Data;

@Data
public class SdrAuthority {
    private long moduleId;
    private String accessPattern; // "crud"
}

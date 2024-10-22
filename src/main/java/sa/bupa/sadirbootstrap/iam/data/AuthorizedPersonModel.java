package sa.bupa.sadirbootstrap.iam.data;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("BUPA_INTERNAL")
@Getter
@Setter
public class AuthorizedPersonModel extends SdrIdentityModel{
    @Column()
    private String authorizedId;
}

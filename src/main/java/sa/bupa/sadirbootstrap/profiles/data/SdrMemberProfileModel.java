package sa.bupa.sadirbootstrap.profiles.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_MEMBER_PROFILES")
@Getter
@Setter
public class SdrMemberProfileModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long leadId; // TODO need entity relation with SdrLeadModel

    private Long membersCount;
    private Long employeeCount;
    private Long dependentsCount;
}

package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LU_LEAD_STATUS")
@Getter
@Setter
public class SdrLeadStatusMasterModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 30)
    private String leadStatus;
    private Integer seqStatus;
}

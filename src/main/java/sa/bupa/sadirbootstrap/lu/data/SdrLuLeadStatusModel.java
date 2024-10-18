package sa.bupa.sadirbootstrap.lu.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LU_LEAD_STATUS")
@Getter
@Setter
public class SdrLuLeadStatusModel {

    @Id
    @GeneratedValue
    private Long id;
    private String leadStatus;
    private Integer seqStatus;

}

package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LEAD_STATUS")
@Getter
@Setter
public class SdrLeadStatusModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String status;
}

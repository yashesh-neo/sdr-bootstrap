package sa.bupa.sadirbootstrap.leads.data;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LU_LEAD_SOURCE_PAGES")
@Getter
@Setter
public class SdrLeadSourcePageMasterModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 30)
    private String slug;
}

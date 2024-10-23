package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LU_CHANNEL")
@Getter
@Setter
public class SdrChannelMasterModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
}

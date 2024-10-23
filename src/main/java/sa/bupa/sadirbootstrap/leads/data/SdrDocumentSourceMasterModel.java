package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LU_DOCUMENT_SOURCE")
@Getter
@Setter
public class SdrDocumentSourceMasterModel {

    @Id
    @GeneratedValue
    private Long id;
    private String sourceName;
}

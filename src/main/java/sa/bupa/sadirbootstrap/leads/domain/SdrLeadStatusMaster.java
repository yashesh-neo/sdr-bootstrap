package sa.bupa.sadirbootstrap.leads.domain;

import lombok.Data;

@Data
public class SdrLeadStatusMaster {
    private long id;
    private String leadStatus;
    private int seqStatus;
}

package sa.bupa.sadirbootstrap.leads.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SdrLead {

    private long id;
    private String authorizedContactEmail;
    private String authorizedContactMobile;
    private Long authorizedId;// TODO need object relation with AuthorizedPerson
    private String userId;
    private String uniqueLoginLink;
    private Date uniqueLoginLinkExpiryDate;
    private String nationalUnifiedNumberSponsor;
    private String quoteId;
    private String nationalUnifiedNumber;
    private String commercialRegistrationNumber;
}

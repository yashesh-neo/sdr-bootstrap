package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SDR_LEADS")
@Getter
@Setter
public class SdrLeadModel {

    @Id
    @GeneratedValue
    private Long id;

    private String authorizedContactEmail;
    private String authorizedContactMobile;
    private Long authorizedId;// TODO need entity relation with AuthorizedPersonModel
    private String userId;

    @Column(unique = true, nullable = false)
    private String uniqueLoginLink;

    @Column(nullable = false)
    private Date uniqueLoginLinkExpiryDate;
    private String nationalUnifiedNumberSponsor;
    private String quoteId;

    @Column(unique = true, length = 15, nullable = false)
    private String nationalUnifiedNumber;

    @Column(unique = true, length = 15, nullable = false)
    private String commercialRegistrationNumber;
}

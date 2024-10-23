package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SDR_LEAD_TRAFFIC_PROFILES")
@Getter
@Setter
public class SdrLeadTrafficProfileModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long leadId; // TODO needs entity relation with SdrLeadModel
    private Long leadStatus; // TODO needs entity relation with SdrLeadStatus

    @Column(length = 15)
    private String languageCode; // TODO needs entity relation
    private Long registeredDevice; // TODO needs entity relation
    private Long usingDevice; // TODO needs entity relation
    private Long productType; // TODO needs entity relation
    private Long channel; // TODO needs entity relation with SdrLuChannelModel
    private Long funnelType; // TODO needs entity relation

    @Column(columnDefinition = "TEXT")
    private String campaignSource;
    private Long leadSourcePage; // TODO needs entity relation
    private Date leadCreationDate;
    private Date leadQualifyingDate;

    @Column(length = 100)
    private String customerIndustry;

    @Column(length = 100)
    private String customerCity;

    @Column(length = 100)
    private String customerRegion;

    @Column(columnDefinition = "TEXT")
    private String accessLinkCommunication;
    private Long getQuoteAccessCount;
    private Date getQuoteAccessDateLatest;

    @Column(columnDefinition = "DOUBLE")
    private Double currentLocationLat;
    @Column(columnDefinition = "DOUBLE")
    private Double currentLocationLng;
}

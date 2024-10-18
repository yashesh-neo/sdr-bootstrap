package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

import java.util.Date;

@Entity
@Table(name = "SDR_LEADS_PROFILE_VALIDATIONS")
@Getter
@Setter
public class SdrLeadsProfileValidationModule {

    @Id
    @GeneratedValue
    private Long id;
    private Long leadId; // TODO need entity relation with SdrLeadModel
    private String leadCrNumber;
    private String leadNationalUnifiedNumber;
    private Integer crValidationStatusBasic;
    private Integer crValidationStatusFull;
    private Integer crTreeValidationStatus;
    private Integer crManagerListValidationStatus;
    private Integer nationalAddressValidationStatus;
    private Integer yakeenManagerValidationStatus;
    private Integer yakeenGroupSecretaryValidationStatus;
    private Date serviceFetchTimeCrBasic;
    private Date serviceFetchTimeCrFull;
    private Date serviceFetchTimeCrTree;
    private Date serviceFetchTimeCrManagers;
    private Date serviceFetchTimeCrNationalAddress;
    private Integer serviceFetchByCrBasic;
    private Integer serviceFetchByCrFull;
    private Integer serviceFetchByCrTree;
    private Integer serviceFetchByCrManagers;
    private Integer serviceFetchByCrNationalAddress;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isManagerPep;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isManagerAuthorized;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isManagerOwner;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isCrMultiSponsor;
    private Integer relatedCrCount;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isManagerListReviewedYakeen;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isCrMultiOwner;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRequiredManagerIdUploaded;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRequiredNationalAddressProofUploaded;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRequiredCompanyProfileUploaded;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isKycHumanValidationRequired;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isCustomerSupportValidationCompleted;
    private Integer customerSupportReviewStatus;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isMuwValidationRequired;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isMuwValidationCompleted;
    private Integer muwReviewStatus;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isSalesQualityValidationRequired;
    private Integer salesQualityReviewStatus;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isSalesQualityValidationCompleted;
    private Date supportQueueAssignmentDate;
    private Long assignedSupportUser;
    private Date muwQueueAssignedDate;
    private Date muwUserAssignedDate;
    private Long muwAssignedUser;
    private Date sqQueueAssignedDate;
    private Date sqUserAssignedDate;
    private Long sqAssignedUser;

}

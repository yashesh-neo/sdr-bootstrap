package sa.bupa.sadirbootstrap.leads.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

import java.util.Date;

@Entity
@Table(name = "SDR_POLICY_AGREEMENT_PROFILE")
@Getter
@Setter
public class SdrPolicyAgreementProfileModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long leadId; // TODO need entity relation with SdrLeadModel

    private String bankName;
    private String bankAccountHolderName;
    private String iban;
    private String vatNumber;
    private Date initialInceptionDate;
    private Date policyInceptionDate;
    private Date policyEndDate;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isMdTermsAcceptance;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isKycTermsAcceptance;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isQuoteTermsAcceptance;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isAgreementTermsAcceptance;
}

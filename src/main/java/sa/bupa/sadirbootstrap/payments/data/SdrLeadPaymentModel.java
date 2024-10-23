package sa.bupa.sadirbootstrap.payments.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SDR_LEAD_PAYMENTS")
@Getter
@Setter
public class SdrLeadPaymentModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 15)
    private String leadCrNumber;

    @Column(length = 15)
    private String leadNationalUnifiedNumber;

    @Column(columnDefinition = "DOUBLE")
    private Float basePremium;

    @Column(columnDefinition = "DOUBLE")
    private Float discountPercentage;

    @Column(columnDefinition = "DOUBLE")
    private Float planDiscountAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float pricingLrPercentage;

    @Column(columnDefinition = "DOUBLE")
    private Float pricingLoadingFactor;

    @Column(columnDefinition = "DOUBLE")
    private Float pricingLoadingAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float loadingAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float surplusAndCreditAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float outstandingAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float totalPremium;

    @Column(columnDefinition = "DOUBLE")
    private Float vatPercentage;

    @Column(columnDefinition = "DOUBLE")
    private Float vatAmount;

    @Column(columnDefinition = "DOUBLE")
    private Float grandTotalPremium;

    private Integer paymentMethod; // TODO needs entity relation here
    private Integer paymentStatus; // TODO needs entity relation here

    @Column(columnDefinition = "TEXT")
    private String paymentReference;

    @Column(columnDefinition = "DOUBLE")
    private Float paidAmount;
    private Long paymentTerms; // TODO needs entity relation here
    private Long paymentTermsType; // TODO needs entity relation here

    @Column(columnDefinition = "TEXT")
    private String sdadReference;
    private Long currencyType; // TODO needs entity relation here
}

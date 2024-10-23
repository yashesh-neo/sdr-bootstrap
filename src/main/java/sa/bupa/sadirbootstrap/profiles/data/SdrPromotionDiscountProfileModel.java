
package sa.bupa.sadirbootstrap.profiles.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.NumericBooleanConverter;

@Entity
@Table(name = "SDR_PROMOTION_DISCOUNT_PROFILES")
@Getter
@Setter
public class SdrPromotionDiscountProfileModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long leadId; // TODO needs entity relation with SdrLeadModel

    @Column(columnDefinition = "TEXT")
    private String partnershipContractNumber;

    @Column(columnDefinition = "TEXT")
    private String partnershipCustomerName;
    private Integer partnershipCustomerType;

    @Column(columnDefinition = "TEXT")
    private String partnershipDiscountOffer;

    @Column(columnDefinition = "TEXT")
    private String uniqueLoginLink;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isPolicyLevelDiscount;

    private Float policyLevelDiscountPercentage;
    private Float classLevelDiscountPercentage;
    private Long discountPlanId;

    @Column(columnDefinition = "TEXT")
    private String discountType;

    @Column(columnDefinition = "TEXT")
    private String discountOfferName;

    @Column(columnDefinition = "TEXT")
    private String discountPromoCodeApplied;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isAutomatedDiscount;
}

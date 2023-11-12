package christmas.domain.dto;

import christmas.domain.Benefit;
import christmas.domain.Order;

public class BenefitDto {

    private final String benefit;

    private BenefitDto(final Benefit benefit){
        this.benefit = benefit.toString();
    }

    public static BenefitDto fromBenefit(final Benefit benefit){
        return new BenefitDto(benefit);
    }

    public String getBenefit() {
        return benefit;
    }

}

package christmas.domain.dto;

import christmas.constants.StringConstants;
import christmas.domain.PayAmount;

public class TotalDiscountDto {
    private final String amount;

    private TotalDiscountDto(final int amount){
        this.amount = StringConstants.WON_FORMAT.format(amount);
    }

    public static TotalDiscountDto fromTotalDiscount(int amount){
        return new TotalDiscountDto(amount);
    }

    public String getTotalDiscountDto() {
        return this.amount;
    }

}

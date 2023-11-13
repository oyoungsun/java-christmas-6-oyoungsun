package christmas.domain.dto;

import christmas.constants.StringConstants;

public class ActualPayDto {
    private final String actualPayAmount;

    private ActualPayDto(final int totalPay, final int totalDiscount) {
        int actualPay = totalPay - totalDiscount;
        this.actualPayAmount = StringConstants.WON_FORMAT.format(actualPay);
    }

    public static ActualPayDto from(final int totalPay, final int totalDiscount) {
        return new ActualPayDto(totalPay, totalDiscount);
    }

    public String getActualPayAmount() {
        return actualPayAmount;
    }
}

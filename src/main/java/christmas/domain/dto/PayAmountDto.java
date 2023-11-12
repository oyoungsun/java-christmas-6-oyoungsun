package christmas.domain.dto;

import christmas.domain.PayAmount;

public class PayAmountDto {
    private final String amount;

    private PayAmountDto(final PayAmount amount){
        this.amount = amount.toString();
    }

    public static PayAmountDto fromPayAmonut(PayAmount amount){
        return new PayAmountDto(amount);
    }

    public String getTotalPayAmount() {
        return this.amount;
    }

}

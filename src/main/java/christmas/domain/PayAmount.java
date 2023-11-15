package christmas.domain;

import static christmas.constants.StringConstants.WON_FORMAT;

import java.text.DecimalFormat;

public class PayAmount {
    final int totalOrderAmount;

    public PayAmount(int totalOrderAmount){
        this.totalOrderAmount = totalOrderAmount;
    }

    public boolean isMoreThan(final int other) {
        return this.totalOrderAmount >= other;
    }

    public int requestTotalPayAmount(int discountAmount){
        return totalOrderAmount - discountAmount;
    }
    public int getTotalOrderAmount() {
        return this.totalOrderAmount;
    }
}

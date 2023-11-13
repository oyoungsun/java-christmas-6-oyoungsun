package christmas.domain;

import java.text.DecimalFormat;

public class PayAmount {
    final int totalOrderAmount;
    final DecimalFormat fomatter = new DecimalFormat("###,###원");

    public PayAmount(int totalOrderAmount){
        this.totalOrderAmount = totalOrderAmount;
    }

    public boolean isMoreThan(final int other) {
        return this.totalOrderAmount >= other;
    }

    public int requestTotalPayAmount(int discountAmount){
        return totalOrderAmount - discountAmount;
    }
    @Override
    public String toString() {
        return fomatter.format(totalOrderAmount);
    }
}

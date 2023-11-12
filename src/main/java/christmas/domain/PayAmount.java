package christmas.domain;

import java.text.DecimalFormat;

public class PayAmount {
    final int totalPayAmount;
    final DecimalFormat fomatter = new DecimalFormat("###,###원");

    public PayAmount(int totalPayAmount){
        this.totalPayAmount = totalPayAmount;
    }

    @Override
    public String toString() {
        return fomatter.format(totalPayAmount);
    }

}

package christmas.domain;

import java.text.DecimalFormat;

public class PayAmonut {
    final int totalPayAmonut;
    final DecimalFormat fomatter = new DecimalFormat("###,###원");

    public PayAmonut(int totalPayAmonut){
        this.totalPayAmonut = totalPayAmonut;
    }

    @Override
    public String toString() {
        return fomatter.format(totalPayAmonut);
    }
}

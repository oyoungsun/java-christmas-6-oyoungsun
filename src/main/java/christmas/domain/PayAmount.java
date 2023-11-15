package christmas.domain;

public class PayAmount {
    final int totalOrderAmount;

    public PayAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public boolean isMoreThan(final int other) {
        return this.totalOrderAmount >= other;
    }

    public int getTotalOrderAmount() {
        return this.totalOrderAmount;
    }
}

package christmas.service;

import christmas.domain.Date;
import christmas.domain.Discount;
import christmas.domain.PayAmount;
import java.util.HashSet;
import java.util.Set;

public class DiscountService {
    private static final int MINIMUM_EVENT_PRICE = 10000;
    private static final String NOTHING = "없음\n";
    private final Set<Discount> discounts;
    private final PayAmount payAmount;
    private final Date date;

    private DiscountService(final PayAmount payAmount, final Date date){
        this.payAmount = payAmount;
        this.date = date;
        this.discounts = new HashSet<>();
    }

    public static DiscountService from(final PayAmount payAmount, final Date date){
        if(payAmount.isMoreThan(MINIMUM_EVENT_PRICE)){
            return new DiscountService(payAmount, date);
        }
        return null;
    }

    public void discount(){
        christmasDiscount();
        weekdayDiscount();
        weekendDiscount();
        benefitEvent();
    }

    private void christmasDiscount() {
        return;
    }

    private void benefitEvent() {
        return;
    }

    private void weekdayDiscount() {
        return;
    }

    private void weekendDiscount() {
        return;
    }

//    public int requestTotalDiscountAmount(){
//        return discounts.stream().
//                mapToInt(
//                        discount -> discount.getDiscountAmount()
//                ).sum();
//    }

    @Override
    public String toString() {
        if(discounts.size()!=0){
            return NOTHING;
        }
        return discounts.stream().toString();
    }
}

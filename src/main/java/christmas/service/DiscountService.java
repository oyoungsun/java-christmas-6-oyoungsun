package christmas.service;

import christmas.domain.ChristmasDiscount;
import christmas.domain.Date;
import christmas.domain.Discount;
import christmas.domain.PayAmount;
import christmas.domain.WeekdayDiscount;
import christmas.domain.WeekendDiscount;
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

    public void discount(int mainCount, int dessertCount){
        int christmasDiscount = christmasDiscount();
        int weekdayDiscount = weekdayDiscount(dessertCount);
        int weekendDiscount =  weekendDiscount(mainCount);
        benefitEvent();
    }

    private int christmasDiscount() {
        Discount christmas = ChristmasDiscount.from(date);
        if(christmas != null) {
            discounts.add(christmas);
            return christmas.reqeustDiscountAmount();
        }
        return 0;
    }

    private int weekdayDiscount(final int dessertCount) {
        Discount weekday = WeekdayDiscount.from(date, dessertCount);
        if(weekday != null){
            discounts.add(weekday);
            return weekday.reqeustDiscountAmount();
        }
        return 0;
    }

    private int weekendDiscount(final int mainCount) {
        Discount weekend = WeekendDiscount.from(date, mainCount);
        if(weekend != null){
            discounts.add(weekend);
            return weekend.reqeustDiscountAmount();
        }
        return 0;
    }

    private void benefitEvent() {
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

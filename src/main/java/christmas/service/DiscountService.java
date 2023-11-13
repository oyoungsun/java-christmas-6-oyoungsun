package christmas.service;

import christmas.constants.StringConstants;
import christmas.domain.discounts.BenefitDiscount;
import christmas.domain.discounts.ChristmasDiscount;
import christmas.domain.Date;
import christmas.domain.discounts.Discount;
import christmas.domain.PayAmount;
import christmas.domain.discounts.WeekdayDiscount;
import christmas.domain.discounts.WeekendDiscount;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public void discount(final int mainCount, final int dessertCount, final boolean isGift){
        int christmasDiscount = christmasDiscount();
        int weekdayDiscount = weekdayDiscount(dessertCount);
        int weekendDiscount =  weekendDiscount(mainCount);
        int benefitDiscount = benefitEvent(isGift);
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

    private int benefitEvent(final boolean isGift) {
        Discount benefit = BenefitDiscount.from(isGift);
        if(benefit != null){
            discounts.add(benefit);
            return benefit.reqeustDiscountAmount();
        }
        return 0;
    }

//    public int requestTotalDiscountAmount(){
//        return discounts.stream().
//                mapToInt(
//                        discount -> discount.getDiscountAmount()
//                ).sum();
//    }

    @Override
    public String toString() {
        if(discounts.size()==0){
            return NOTHING;
        }
        return discounts.stream().map(Object::toString).collect(Collectors.joining(StringConstants.ENTER));
    }
}

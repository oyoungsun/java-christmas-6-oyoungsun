package christmas.service;

import christmas.constants.StringConstants;
import christmas.domain.discounts.BenefitDiscount;
import christmas.domain.discounts.ChristmasDiscount;
import christmas.domain.Date;
import christmas.domain.discounts.Discount;
import christmas.domain.PayAmount;
import christmas.domain.discounts.SpecialDiscount;
import christmas.domain.discounts.WeekdayDiscount;
import christmas.domain.discounts.WeekendDiscount;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DiscountService {
    private static final int MINIMUM_EVENT_PRICE = 10000;
    private static final String NOTHING = "없음\n";
    private static int gift = 0;
    private final Map<Discount, Integer> discounts;
    private final PayAmount payAmount;
    private final Date date;


    private DiscountService(final PayAmount payAmount, final Date date){
        this.payAmount = payAmount;
        this.date = date;
        this.discounts = new HashMap<>();
    }

    public static DiscountService from(final PayAmount payAmount, final Date date){
        if(payAmount.isMoreThan(MINIMUM_EVENT_PRICE)){
            return new DiscountService(payAmount, date);
        }
        return null;
    }

    public void discount(final int mainCount, final int dessertCount, final boolean isGift){
        christmasDiscount();
        weekdayDiscount(dessertCount);
        weekendDiscount(mainCount);
        specialDiscount();
        benefitEvent(isGift);
    }

    private void specialDiscount() {
        Discount special = SpecialDiscount.from(date);
        if(special != null){
            int specialDiscount = special.reqeustDiscountAmount();
            discounts.put(special, specialDiscount);
        }
    }

    private void christmasDiscount() {
        Discount christmas = ChristmasDiscount.from(date);
        if(christmas != null) {
            int christmasDiscount = christmas.reqeustDiscountAmount();
            discounts.put(christmas, christmasDiscount);

        }
    }

    private void weekdayDiscount(final int dessertCount) {
        Discount weekday = WeekdayDiscount.from(date, dessertCount);
        if(weekday != null){
            int weekdayDiscount = weekday.reqeustDiscountAmount();
            discounts.put(weekday, weekdayDiscount);
        }
    }

    private void weekendDiscount(final int mainCount) {
        Discount weekend = WeekendDiscount.from(date, mainCount);
        if(weekend != null){
            int weekendDiscount = weekend.reqeustDiscountAmount();
            discounts.put(weekend, weekendDiscount);
        }
    }

    private void benefitEvent(final boolean isGift) {
        Discount benefit = BenefitDiscount.from(isGift);
        if(benefit != null){
            gift = benefit.reqeustDiscountAmount();
            discounts.put(benefit, gift);
        }
    }

    public int requestTotalDiscountAmount(){
        return discounts.entrySet().stream().mapToInt(discount -> discount.getValue()).sum();
    }

    public int requestActualDiscountAmount(){
        if(gift!=0) {
            return discounts.entrySet().stream().mapToInt(discount -> discount.getValue()).sum() - gift;
        }
        return discounts.entrySet().stream().mapToInt(discount -> discount.getValue()).sum();
    }

    @Override
    public String toString() {
        if(discounts.size()==0){
            return NOTHING;
        }
        return discounts.entrySet().stream().map(Object::toString).collect(Collectors.joining(StringConstants.ENTER));
    }
}

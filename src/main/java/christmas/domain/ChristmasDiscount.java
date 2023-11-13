package christmas.domain;

public class ChristmasDiscount implements Discount{

    private static final int CHRISTMAS = 25;
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DAY_DISCOUNT = 100;
    private static final int FIRST_DAY = 1;

    private final Date date;

    private ChristmasDiscount(final Date date){
        this.date = date;
    }

    public static ChristmasDiscount from(final Date date) {
        if(date.isBefore(CHRISTMAS)){
            return new ChristmasDiscount(date);
        }
        return null;
    }

    @Override
    public int reqeustDiscountAmount() {
        return INITIAL_DISCOUNT + (date.getDifferent(FIRST_DAY)) * DAY_DISCOUNT;
    }
}

package christmas.domain;

public class Benefit {
    private static final String GIFT = "샴페인 1개";
    private static final String NOTHING = "없음";
    private final boolean isGift;

    public Benefit(final boolean isGift) {
        this.isGift = isGift;
    }

    public static Benefit from(final boolean isGift) {
        return new Benefit(isGift);
    }

    public String getGiftString() {
        if(isGift){
            return GIFT;
        }
        return NOTHING;
    }

    public boolean isGift() {
        return isGift;
    }

}

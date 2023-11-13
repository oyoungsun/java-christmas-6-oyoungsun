package christmas.constants;

public enum EventType {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int nedeed;

    private EventType(final String name, final int nedeed) {
        this.name = name;
        this.nedeed = nedeed;
    }

    public static String findEventByMoney(final int discountAmonut) {
        if (discountAmonut < STAR.nedeed) {
            return "없음";
        }
        if (discountAmonut < TREE.nedeed) {
            return STAR.name;
        }
        if (discountAmonut < SANTA.nedeed) {
            return TREE.name;
        }
        return SANTA.name;
    }

}

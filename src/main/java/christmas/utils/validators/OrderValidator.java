package christmas.utils.validators;

import christmas.domain.OrderItem;
import java.util.List;

public class OrderValidator {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 20;

    public void validate(final List<OrderItem> orderItems) {
        if (!isAllItemInRange(orderItems)) {
            throw new IllegalArgumentException(
                    String.format("메뉴 주문은 한 번에 최소 %d개 이상, 최대 %d개까지만 주문할 수 있습니다.", MIN_COUNT, MAX_COUNT));
        }
        if (isAllDrink(orderItems)) {
            throw new IllegalArgumentException("음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    private boolean isAllItemInRange(final List<OrderItem> orderItems) {
        int sum = orderItems.stream().mapToInt(item -> item.getCount()).sum();
        return MIN_COUNT <= sum && sum <= MAX_COUNT;
    }

    private boolean isAllDrink(final List<OrderItem> orderItems) {
        int drinkCount = (int) orderItems.stream().filter(item -> item.isDrink()).count();
        return orderItems.size() == drinkCount;
    }

}

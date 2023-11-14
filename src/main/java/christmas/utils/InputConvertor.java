package christmas.utils;

import christmas.constants.StringConstants;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.utils.validators.DateValidator;
import christmas.utils.validators.InputValidator;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    private static final String COMMA = ",";
    private static final String DASH = "-";

    public Date convertDate(final String input, DateValidator validator) {
        int day = 0;
        try {
            day = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return Date.from(day, validator);
    }

    public Order convertOrder(final List<OrderItem> input, final OrderValidator validator) {
        return Order.from(input, validator);
    }

    public List<OrderItem> convertOrderItems(String input, final OrderItemValidator validator) {
        String[] inputs = input.split(COMMA);
        List<OrderItem> items = new ArrayList<>();
        for (String item : inputs) {
            OrderItem orderItem = convertOrderItem(item, validator);
            items.add(orderItem);
        }
        return items;
    }

    private OrderItem convertOrderItem(final String item, final OrderItemValidator validator) {
        String[] splitedByDash = item.split(DASH);
        if(splitedByDash.length != 2) throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        String menu = splitedByDash[0];
        int count = covertStringToCount(splitedByDash[1]);
        return OrderItem.of(menu, count, validator);
    }

    private int covertStringToCount(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}

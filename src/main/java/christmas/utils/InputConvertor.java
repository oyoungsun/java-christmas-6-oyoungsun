package christmas.utils;

import christmas.constants.StringConstants;
import christmas.domain.Date;
import christmas.domain.OrderItem;
import christmas.utils.validators.DateValidator;
import christmas.utils.validators.OrderItemValidator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    private static final String COMMA = ",";
    private static final String DASH = "-";

    public Date convertDate(final String input, DateValidator validator) {
        int day = covertStringToInt(input);
        return Date.from(day, validator);
    }

    private int covertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 문자가 정수가 아닙니다");
        }
    }

    public String[] convertOrder(final String input) {
        return input.split(COMMA);
    }

    public List<OrderItem> convertOrderItems(String[] input, final OrderItemValidator validator) {
        List<OrderItem> items = new ArrayList<>();
        for (String item : input) {
            OrderItem orderItem = convertOrderItem(validator, item);
            items.add(orderItem);
        }
        return items;
    }

    private OrderItem convertOrderItem(final OrderItemValidator validator, final String item) {
        String[] splitedByDash = item.split(DASH);
        String menu = splitedByDash[0];
        int count = covertStringToInt(splitedByDash[1]);
        return OrderItem.of(menu, count, validator);
    }
}

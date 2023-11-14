package christmas.utils;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.utils.validators.DateValidator;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    private static final String COMMA = ",";
    public Date convertDate(final String input, DateValidator validator) {
        int day = covertStringToInt(input);
        return Date.from(day, validator);
    }

    private int covertStringToInt(final String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력한 문자가 정수가 아닙니다");
        }
    }

    public String[] convertOrder(final String input) {
        return input.split(COMMA);
    }

    public List<OrderItem> convertOrderItems(final String[] input, final OrderItemValidator validator){
        List<OrderItem> items = new ArrayList<>();
        for(String item : input){
            String[] name = item.split(" ");
            String menu = name[0];
            String count = name[1].split("개")[0];
            int cnt = covertStringToInt(count);
            OrderItem orderItem = OrderItem.of(menu, cnt, validator);
            items.add(orderItem);
        }
        return items;
    }
}

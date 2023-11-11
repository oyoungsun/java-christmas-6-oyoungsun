package christmas.domain;

import christmas.constants.StringConstants;
import christmas.utils.validators.OrderItemValidator;

public class OrderItem {
    private final Menu menu;
    private final int count;

    private OrderItem(final Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static OrderItem of(final String menuName, final int count, OrderItemValidator orderItemValidator){
        orderItemValidator.validate(menuName, count);
        Menu menu = Menu.findMenuByName(menuName);
        return new OrderItem(menu, count);
    }

    @Override
    public String toString() {
        return menu.getName() + StringConstants.SPACE
                + count + "개";
    }

    public int getCount() {
        return count;
    }

    public boolean isDrink() {
        return MenuType.isDrink(menu);
    }

}

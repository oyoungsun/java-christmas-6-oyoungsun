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

    public static OrderItem of(final String menuName, final int count, OrderItemValidator orderItemValidator) {
        orderItemValidator.validate(menuName, count);
        Menu menu = Menu.findMenuByName(menuName);
        return new OrderItem(menu, count);
    }

    public int requestPrice() {
        return menu.requestPrice(count);
    }

    public boolean isDrink() {
        return MenuType.isDrink(menu);
    }

    public int requestMainCount() {
        if (MenuType.isMain(menu)) {
            return this.count;
        }
        return 0;
    }

    public int requestDessertCount() {
        if (MenuType.isDessert(menu)) {
            return this.count;
        }
        return 0;
    }

    public String getOrderItemString() {
        return menu.getName() + StringConstants.SPACE
                + count + "개";
    }

    public int getCount() {
        return count;
    }

}

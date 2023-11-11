package christmas.view;

import christmas.domain.dto.OrderOuputDto;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    public void printOrderMenu(OrderOuputDto orders){
        System.out.println(ORDER_MENU);
        System.out.println(orders.getOrders());
    }

}

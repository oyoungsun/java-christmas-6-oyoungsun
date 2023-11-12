package christmas.view;

import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_AMOUNT = "<할인 전 총주문 금액>";

    public void printOrderMenu(OrderOuputDto orders){
        System.out.println(ORDER_MENU);
        System.out.println(orders.getOrders());
    }
    public void printTotalPayAmonut(PayAmountDto amonut){
        System.out.println(amonut.getTotalPayAmount());
    }

}

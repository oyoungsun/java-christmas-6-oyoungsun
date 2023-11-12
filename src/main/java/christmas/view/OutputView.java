package christmas.view;

import christmas.domain.Benefit;
import christmas.domain.dto.BenefitDto;
import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_AMOUNT = "<할인 전 총주문 금액>";
    private static final String BENEFIT_MENU = "<증정 메뉴>";


    public void printOrderMenu(OrderOuputDto orders){
        System.out.println(ORDER_MENU);
        System.out.println(orders.getOrders());
    }
    public void printTotalPayAmonut(PayAmountDto amonut){
        System.out.println(TOTAL_AMOUNT);
        System.out.println(amonut.getTotalPayAmount());
    }

    public void printBenefit(BenefitDto benefit){
        System.out.println(BENEFIT_MENU);
        System.out.println(benefit.getBenefit());
    }

}

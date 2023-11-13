package christmas.view;

import christmas.domain.Benefit;
import christmas.domain.dto.BenefitDto;
import christmas.domain.dto.DiscountDto;
import christmas.domain.dto.EventDto;
import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;
import christmas.domain.dto.TotalDiscountDto;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_PAY_AMOUNT = "<할인 전 총주문 금액>";
    private static final String BENEFIT_MENU = "<증정 메뉴>";
    private static final String DISCOUNT_MENU = "<혜택 내역>";
    private static final String TOTAL_DISCOUNT_AMOUNT = "<총혜택 금액>";
    private static final String EVENT_BADGY = "<12월 이벤트 배지>";



    public void printOrderMenu(OrderOuputDto orders){
        System.out.println(ORDER_MENU);
        System.out.println(orders.getOrders());
    }
    public void printTotalPayAmonut(PayAmountDto amonut){
        System.out.println(TOTAL_PAY_AMOUNT);
        System.out.println(amonut.getTotalPayAmount());
    }

    public void printBenefit(BenefitDto benefit){
        System.out.println(BENEFIT_MENU);
        System.out.println(benefit.getBenefit());
    }

    public void printDiscount(DiscountDto discount){
        System.out.println(DISCOUNT_MENU);
        System.out.println(discount.getTotalDiscount());
    }

    public void printTotalDiscountAmonut(TotalDiscountDto totalDiscount){
        System.out.println(TOTAL_DISCOUNT_AMOUNT);
        System.out.println(totalDiscount.getTotalDiscountDto());
    }

    public void printEventBadgy(EventDto event){
        System.out.println(EVENT_BADGY);
        System.out.println(event.getBadgy());
    }
}

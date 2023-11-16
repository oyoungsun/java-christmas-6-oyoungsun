package christmas.view;

import christmas.constants.StringConstants;
import christmas.domain.dto.ActualPayDto;
import christmas.domain.dto.BenefitDto;
import christmas.domain.dto.DiscountDto;
import christmas.domain.dto.EventDto;
import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;
import christmas.domain.dto.TotalDiscountDto;

public class OutputView {
    private static final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EXPECTED_EVENT = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_PAY_AMOUNT = "<할인 전 총주문 금액>";
    private static final String BENEFIT_MENU = "<증정 메뉴>";
    private static final String DISCOUNT_MENU = "<혜택 내역>";
    private static final String TOTAL_DISCOUNT_AMOUNT = "<총혜택 금액>";
    private static final String ACTUAL_PAY_AMOUNT = "<할인 후 예상 결제 금액>";

    private static final String EVENT_BADGY = "<12월 이벤트 배지>";

    public static void printHello() {
        System.out.println(HELLO);
    }

    public static void printExpectEvent() {
        System.out.println(EXPECTED_EVENT);
        printEmpty();
    }

    public static void printOrderMenu(OrderOuputDto orders) {
        System.out.println(ORDER_MENU);
        System.out.println(orders.getOrders());
    }

    public static void printTotalPayAmount(PayAmountDto amonut) {
        System.out.println(TOTAL_PAY_AMOUNT);
        System.out.println(amonut.getTotalPayAmount());
        printEmpty();
    }

    public static void printBenefit(BenefitDto benefit) {
        System.out.println(BENEFIT_MENU);
        System.out.println(benefit.getBenefit());
        printEmpty();
    }

    public static void printDiscount(DiscountDto discount) {
        System.out.println(DISCOUNT_MENU);
        System.out.println(discount.getTotalDiscount());
        printEmpty();
    }

    public static void printTotalDiscountAmount(TotalDiscountDto totalDiscount) {
        System.out.println(TOTAL_DISCOUNT_AMOUNT);
        System.out.println(totalDiscount.getTotalDiscountDto());
        printEmpty();
    }

    public static void printActualPayAmount(ActualPayDto actualPayDto) {
        System.out.println(ACTUAL_PAY_AMOUNT);
        System.out.println(actualPayDto.getActualPayAmount());
        printEmpty();
    }


    public static void printEventBadgy(EventDto event) {
        System.out.println(EVENT_BADGY);
        System.out.println(event.getBadgy());
    }

    public static void printExceptionMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static void printEmpty() {
        System.out.print(StringConstants.ENTER);
    }
}

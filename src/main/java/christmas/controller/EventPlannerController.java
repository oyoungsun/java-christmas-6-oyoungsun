package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.PayAmount;
import christmas.domain.dto.ActualPayDto;
import christmas.domain.dto.EventDto;
import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;
import christmas.domain.dto.TotalDiscountDto;
import christmas.service.BenefitService;
import christmas.service.DiscountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    private final InputView inputView;
    private DiscountService discountService;
    private BenefitService benefitService;
    private Order order;
    private Date date;
    private PayAmount payAmount;

    public EventPlannerController(final InputView inputView){
        this.inputView = inputView;
    }

    public void run(){
        guideOrderInformation();
        int totalOrderAmount = orderMenu();
        PayAmount payAmount = new PayAmount(totalOrderAmount);
        requestTotalOrder();
        discountService = DiscountService.from(payAmount, date);
        benefitService = BenefitService.from(payAmount);
        discount();
        int totalDiscountAmount = sale();
        total();
        badgy(totalDiscountAmount);
    }
        private void guideOrderInformation() {
        OutputView.printHello();
        date = inputView.readDate();
        order = inputView.readOrder();
        OutputView.printExpectEvent();

    }

    private int orderMenu() {
        OrderOuputDto orderOuputDto = OrderOuputDto.fromOrder(order);
        OutputView.printOrderMenu(orderOuputDto);
        return order.requestTotalPrice();
    }
    private void requestTotalOrder() {
        PayAmountDto payAmonutDto = PayAmountDto.fromPayAmonut(payAmount);
        OutputView.printTotalPayAmount(payAmonutDto);
    }

    private void discount() { // 증정, 혜택, 할
        int mainCount = order.requestMainCount();
        int dessertCount = order.requestDessertCount();
        boolean isGift = benefitService.isGift();
        discountService.discount(mainCount, dessertCount, isGift);
    }

    private int sale() {
        int totalDiscountAmount = discountService.requestTotalDiscountAmount();
        TotalDiscountDto totalDiscountDto = TotalDiscountDto.fromTotalDiscount(totalDiscountAmount);
        OutputView.printTotalDiscountAmount(totalDiscountDto);
        return totalDiscountAmount;
    }

    private void total() {
        int totalActualDiscountAmount = discountService.requestActualDiscountAmount();
        int totalPrice = order.requestTotalPrice();
        ActualPayDto actualPayDto = ActualPayDto.from(totalPrice, totalActualDiscountAmount);
        OutputView.printActualPayAmount(actualPayDto);
    }

    private void badgy(final int totalDiscountAmount) {
        Event event = new Event(totalDiscountAmount);
        EventDto eventDto = EventDto.fromEvent(event);
        OutputView.printEventBadgy(eventDto);
    }

}

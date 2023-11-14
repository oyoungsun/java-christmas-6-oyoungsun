package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.PayAmount;
import christmas.domain.dto.ActualPayDto;
import christmas.domain.dto.EventDto;
import christmas.domain.dto.OrderOuputDto;
import christmas.domain.dto.PayAmountDto;
import christmas.domain.dto.TotalDiscountDto;
import christmas.service.BenefitService;
import christmas.service.DiscountService;
import christmas.utils.InputConvertor;
import christmas.utils.exception.ExceptionHandler;
import christmas.utils.validators.DateValidator;
import christmas.utils.validators.OrderItemValidator;
import christmas.utils.validators.OrderValidator;
import christmas.view.Input;
import christmas.view.OutputView;
import java.util.List;

public class EventPlannerController {
    private final Input inputView;
    private final InputConvertor convertor;
    private DiscountService discountService;
    private BenefitService benefitService;
    private Order order;
    private Date date;
    private PayAmount payAmount;

    private EventPlannerController(final Input inputView, final InputConvertor convertor){
        this.inputView = inputView;
        this.convertor = convertor;
    }

    public static EventPlannerController of(final Input input, final InputConvertor convertor) {
        return new EventPlannerController(input, convertor);
    }

    public void run(){
        guideOrderInformation();
        int totalOrderAmount = orderMenu();
        payAmount = new PayAmount(totalOrderAmount);
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
        String day = inputView.readDate();
        date = ExceptionHandler.convert(convertor::convertDate, day, new DateValidator());

        String orders = inputView.readOrder();
        List<OrderItem> orderItems = ExceptionHandler.convert(convertor::convertOrderItems, orders, new OrderItemValidator());
        order = ExceptionHandler.convert(convertor::convertOrder, orderItems, new OrderValidator());
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

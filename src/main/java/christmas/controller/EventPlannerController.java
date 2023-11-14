package christmas.controller;

import christmas.domain.Benefit;
import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.domain.PayAmount;
import christmas.domain.dto.ActualPayDto;
import christmas.domain.dto.BenefitDto;
import christmas.domain.dto.DiscountDto;
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

    private EventPlannerController(final Input inputView, final InputConvertor convertor) {
        this.inputView = inputView;
        this.convertor = convertor;
    }

    public static EventPlannerController of(final Input input, final InputConvertor convertor) {
        return new EventPlannerController(input, convertor);
    }

    public void run() {
        OutputView.printHello();
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
        String day = inputView.readDate();
        date = ExceptionHandler.convert(convertor::convertDate, day, new DateValidator());
        if (date == null) {
            guideOrderInformation();
        }
        List<OrderItem> orderItems = guideOrder();
        order = ExceptionHandler.convert(convertor::convertOrder, orderItems, new OrderValidator());
        if (order == null) {
            guideOrder();
        }
        OutputView.printExpectEvent();
    }

    private List<OrderItem> guideOrder() {
        String orders = inputView.readOrder();
        List<OrderItem> orderItems = ExceptionHandler.convert(convertor::convertOrderItems, orders,
                new OrderItemValidator());
        if (orderItems == null) {
            guideOrder();
        }
        return orderItems;
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

    private void discount() {
        int mainCount = order.requestMainCount();
        int dessertCount = order.requestDessertCount();
        Benefit benefit = benefitService.getBenefit();
        discountService.discount(mainCount, dessertCount, benefit.isGift());
        OutputView.printBenefit(BenefitDto.fromBenefit(benefit));
        OutputView.printDiscount(DiscountDto.fromDiscount(discountService));
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

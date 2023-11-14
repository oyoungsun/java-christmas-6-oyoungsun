package christmas.controller;


import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.BenefitService;
import christmas.service.DiscountService;
import christmas.view.InputView;

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
        guide();
        int totalOrderAmount = orderMenu();
        requestTotalOrder(totalOrderAmount);
        discount();
        int totalDiscountAmount = sale();
        total();
        badgy(totalDiscountAmount);
    }

}

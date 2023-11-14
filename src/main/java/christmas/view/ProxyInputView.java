package christmas.view;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.utils.exception.ExceptionHandler;

public class ProxyInputView implements Input{
    private final Input viewable;

    public ProxyInputView(Input viewable) {
        this.viewable = viewable;
    }

//    @Override
//    public Money getMoneyInput() {
//        return ExceptionHandler.input(viewable::getMoneyInput);
//    }

    @Override
    public Date readDate() {
        return ExceptionHandler.input(viewable::readDate);
    }

    @Override
    public Order readOrder() {
        return ExceptionHandler.input(viewable::readOrder);
    }

}

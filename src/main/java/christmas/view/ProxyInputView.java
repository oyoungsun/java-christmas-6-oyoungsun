package christmas.view;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.utils.exception.ExceptionHandler;

public class ProxyInputView implements Input{
    private final Input viewable;

    public ProxyInputView(Input viewable) {
        this.viewable = viewable;
    }

    @Override
    public String readDate() {
        return ExceptionHandler.input(viewable::readDate);
    }

    @Override
    public String readOrder() {
        return ExceptionHandler.input(viewable::readOrder);
    }

}

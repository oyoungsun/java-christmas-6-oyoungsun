package christmas.view;

import christmas.utils.exception.ExceptionHandler;

public class ProxyInputView implements Input {
    private final Input viewable;

    public ProxyInputView(Input viewable) {
        this.viewable = viewable;
    }

    @Override
    public String readDate() {
        return ExceptionHandler.input(viewable::readDate, 0);
    }

    @Override
    public String readOrder() {
        return ExceptionHandler.input(viewable::readOrder, 0);
    }

}

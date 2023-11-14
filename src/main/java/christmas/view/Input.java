package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.domain.Order;

public interface Input {
    Date readDate();
    Order readOrder();
}

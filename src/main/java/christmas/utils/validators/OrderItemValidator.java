package christmas.utils.validators;

import christmas.domain.Menu;

public class OrderItemValidator {

    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 20;

    public void validate(final String menuName, final int count) {
        if(!isThereName(menuName)){
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if(!isCountInRange(count)){
            throw new IllegalArgumentException(String.format("한 메뉴당 최소 %d개 이상, 최대 %d개까지만 주문할 수 있습니다.",MIN_COUNT, MAX_COUNT));
        }
    }

    private boolean isThereName(final String menuName) {
        Menu menu = Menu.findMenuByName(menuName);
        if(menu == null) return false;
        return true;
    }

    private boolean isCountInRange(final int count) {
        return MIN_COUNT <= count && count <= MAX_COUNT;
    }

}

package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.validators.InputValidator;

public class InputView implements Input {

    private static final InputView inputView = new InputView();
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String MENU_INPUT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final InputValidator validator = new InputValidator();

    public static Input getInstance() {
        return new ProxyInputView(inputView);
    }

    @Override
    public String readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        String input = Console.readLine();
        return validator.validate(input);
    }

    @Override
    public String readOrder() {
        System.out.println(MENU_INPUT_MESSAGE);
        String input = Console.readLine();
        return validator.validate(input);
    }

}

package christmas;

import christmas.controller.EventPlannerController;
import christmas.utils.InputConvertor;
import christmas.view.Input;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        Input input = InputView.getInstance();
        InputConvertor convertor = new InputConvertor();
        EventPlannerController controller = EventPlannerController.of(input, convertor);
        controller.run();
    }
}

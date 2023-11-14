package christmas;

import christmas.controller.EventPlannerController;
import christmas.view.Input;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        Input input = InputView.getInstance();
        EventPlannerController controller = new EventPlannerController(input);
        controller.run();
    }
}

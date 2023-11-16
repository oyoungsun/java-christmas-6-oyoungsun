package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum MenuType {
    APPETIZER(Arrays.asList(Menu.SOUP, Menu.TAPAS, Menu.SALAD)),
    MAIN(Arrays.asList(Menu.STEAK, Menu.RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT(Arrays.asList(Menu.CAKE, Menu.ICECREAM)),
    DRINK(Arrays.asList(Menu.COLA, Menu.WINE, Menu.CHAMPAGNE));

    private final List<Menu> menuGroup;

    MenuType(final List<Menu> menuGroup) {
        this.menuGroup = menuGroup;
    }

    public static boolean isDrink(final Menu menu) {
        return DRINK.menuGroup.stream().anyMatch(drink -> drink == menu);
    }

    public static boolean isMain(final Menu menu) {
        return MAIN.menuGroup.stream().anyMatch(drink -> drink == menu);
    }

    public static boolean isDessert(final Menu menu) {
        return DESSERT.menuGroup.stream().anyMatch(drink -> drink == menu);
    }

}

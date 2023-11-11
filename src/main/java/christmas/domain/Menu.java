package christmas.domain;

import java.util.Arrays;

public enum Menu {
    SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    SALAD("시저샐러드",8000),
    STEAK("티본스테이크", 55000),
    RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타",35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    CAKE("초코케이크", 15000),
    ICECREAM("아이스크림", 5000),
    COLA("제로콜라", 3000),
    WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;

    private Menu(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Menu findMenuByName(final String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(menuName))
                .findAny()
                .orElse(null);
    }

    public String getName() {
        return this.name;
    }
}

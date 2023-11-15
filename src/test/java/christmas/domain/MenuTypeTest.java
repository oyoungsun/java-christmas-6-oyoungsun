package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTypeTest {

    private static Stream<Arguments> generateDesertMenus() {
        return Stream.of(Arguments.of(Menu.COLA, true),
                Arguments.of(Menu.SOUP, false),
                Arguments.of(Menu.CHAMPAGNE, true)
        );
    }

    private static Stream<Arguments> generateMainMenus() {
        return Stream.of(Arguments.of(Menu.COLA, false),
                Arguments.of(Menu.SOUP, false),
                Arguments.of(Menu.CHRISTMAS_PASTA, true)
        );
    }

    private static Stream<Arguments> generateDessertMenus() {
        return Stream.of(Arguments.of(Menu.COLA, false),
                Arguments.of(Menu.CAKE, true),
                Arguments.of(Menu.ICECREAM, true)
        );
    }

    @ParameterizedTest
    @MethodSource("generateDesertMenus")
    void isDrink는_주어진메뉴가_음료인지_판단한다(Menu menu, boolean expected) {
        //when
        boolean result = MenuType.isDrink(menu);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateMainMenus")
    void isMain는_주어진메뉴가_메인메뉴인지_판단한다(Menu menu, boolean expected) {
        //when
        boolean result = MenuType.isMain(menu);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateDessertMenus")
    void isDessert는_주어진메뉴가_디저트인지_판단한다(Menu menu, boolean expected) {
        //when
        boolean result = MenuType.isDessert(menu);
        //then
        assertThat(result).isEqualTo(expected);
    }

}
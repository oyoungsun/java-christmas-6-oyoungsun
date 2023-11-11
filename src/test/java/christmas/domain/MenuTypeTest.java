package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.TestFactory;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTypeTest {

    @ParameterizedTest
    @MethodSource("generateMenus")
    void isDrink는_주어진메뉴가_음료인지_판단한다(Menu menu, boolean expected){
        //when
        boolean result = MenuType.isDrink(menu);
        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateMenus(){
        return Stream.of(Arguments.of(Menu.COLA, true),
                Arguments.of(Menu.SOUP, false),
                Arguments.of(Menu.CHAMPAGNE, true)
        );
    }
}
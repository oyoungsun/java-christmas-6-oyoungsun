package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"초코케이크", "레드와인", "해산물파스타"})
    void 메뉴이름_받으면_맞는Menu객체를_반환한다(String menuName) {
        Menu menu = Menu.findMenuByName(menuName);
        assertThat(menu).isInstanceOf(Menu.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"초코케이크22", "레,드와인", "해산물파스 타"})
    void 없는메뉴이름_받으면_맞는Menu객체를_반환한다(String wrongName) {
        Menu menu = Menu.findMenuByName(wrongName);
        assertThat(menu).isNull();
    }

}

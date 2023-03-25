package ch.css.al1.russianpeasant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
class RussianpeasantMultiplicatorTest {
    public static Stream<Arguments> testdataprovider() {
        return Stream.of(
                Arguments.of(1,1,1),
                Arguments.of(1,2,2),
                Arguments.of(1,3,3),
                Arguments.of(2,3,6),
                Arguments.of(47,42,1974)
        );
    }
    @ParameterizedTest
    @MethodSource("testdataprovider")
    void testMultiplicator(int x, int y, int expected) {
        RussianpeasantMultiplicator testee = new RussianpeasantMultiplicator();

        int actual = testee.mul(x,y);

        assertThat(actual).isEqualTo(expected);
    }

}

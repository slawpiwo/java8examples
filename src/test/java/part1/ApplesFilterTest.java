package part1;

import org.junit.Test;
import share.Apple;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ApplesFilterTest {

    private List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(120, "green"),
            new Apple(160, "red"));

    private ApplesFilter filter = new ApplesFilter();
    private List<Apple> result;


    @Test
    public void shouldFilterByColor() {
        //when
        result = filter.filter(inventory, a -> "green".equals(a.getColor()));

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void shouldFilterByWeight() {
        //when
        result = filter.filter(inventory, a -> a.getWeight() > 120);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getWeight()).isEqualTo(160);
    }

    @Test
    public void shouldReturnHeavyAndRed() {
        //when
        result = filter.filter(inventory, ApplesFilterTest::isHeavyAndRed);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getWeight()).isEqualTo(160);
        assertThat(result.get(0).getColor()).isEqualTo("red");
    }

    private static boolean isHeavyAndRed(Apple apple) {
        return (apple.getWeight() > 120) && ("red".equals(apple.getColor()));
    }

}
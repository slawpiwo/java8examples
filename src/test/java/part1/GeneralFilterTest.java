package part1;

import org.junit.Test;
import share.Apple;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralFilterTest {

    private List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(120, "green"),
            new Apple(160, "red"));

    private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


    @Test
    public void shouldReturnAllRedApples() {
        //given
        GeneralFilter<Apple> applesFilter = new GeneralFilter<>();

        //when
        List<Apple> result = applesFilter.filter(inventory, a -> "red".equals(a.getColor()));

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getColor()).isEqualTo("red");
    }


    @Test
    public void shouldReturnEvenNumber() {
        //given
        GeneralFilter<Integer> numbersFilter = new GeneralFilter<>();

        //when
        List<Integer> result = numbersFilter.filter(numbers, n -> n % 2 == 0);

        //then
        assertThat(result).containsExactly(2, 4, 6, 8);
    }
}
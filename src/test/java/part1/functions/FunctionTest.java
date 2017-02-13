package part1.functions;


import org.junit.Test;
import org.mockito.InOrder;
import part1.ApplesFilter;
import share.Apple;

import java.util.*;
import java.util.function.*;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class FunctionTest {

    @Test
    public void shouldReturnStringFromInteger() {
        //given
        final Function<Integer, String> function = integer -> "The result is " + integer;

        //when
        String text = function.apply(128);

        //then
        assertThat(text).isEqualTo("The result is 128");
    }

    @Test
    public void shouldProduceNumber() {
        //given
        final Supplier<Integer> supplier = () -> 128;

        //when
        Integer integer = supplier.get();

        //then
        assertThat(integer).isEqualTo(128);
    }

    @Test
    public void shouldProduceTheApple() {
        //given
        final Supplier<Apple> appleSupplier1 = () -> new Apple(150, "yellow");
        final BiFunction<Integer, String, Apple> appleSupplier2 = Apple::new;

        //when
        Apple apple1 = appleSupplier1.get();
        Apple apple2 = appleSupplier2.apply(150, "yellow");

        //then
        assertThat(apple1).isNotNull();
        assertThat(apple1).isEqualTo(apple2);
    }

    @Test
    public void shouldDecideIfNegative() {
        //given
        final DoublePredicate isNegative = d -> d < 0;
        final DoublePredicate isNotNegative = isNegative.negate();

        //when
        boolean result1 = isNegative.test(3.1);
        boolean result2 = isNotNegative.test(-3.1);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
    }

    @Test
    public void shouldCallOtherClassInConsumer() {
        //given
        final Date date = mock(Date.class);
        final LongConsumer consumer = date::setTime;

        //when
        consumer.accept(12345L);
        consumer.accept(45678L);

        //then
        InOrder order = inOrder(date);
        order.verify(date).setTime(12345L);
        order.verify(date).setTime(45678L);
    }

    @Test
    public void shouldComposeFunctions() {
        //given
        Function<Integer, Integer> f = x-> x + 1;
        Function<Integer, Integer> g = x-> x * 2;

        //when
        Integer result1 = f.andThen(g).apply(1);
        Integer result2 = f.compose(g).apply(1);

        //then
        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(3);
    }

    public void shouldChainComparator() {
        //given
        final List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(120, "green"),
                new Apple(120, "red"));

        //when
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        for (Apple a: inventory) {
            System.out.println(a);
        }
    }



}

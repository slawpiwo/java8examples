package part1;


import share.Apple;

import java.util.function.Predicate;

public class LightAndGreenPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return (apple.getWeight() < 120 && "green".equals(apple.getColor()));
    }
}

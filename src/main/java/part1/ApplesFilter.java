package part1;

import share.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ApplesFilter {

    public List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

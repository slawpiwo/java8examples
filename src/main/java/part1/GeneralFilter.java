package part1;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GeneralFilter<T> {

    public List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}

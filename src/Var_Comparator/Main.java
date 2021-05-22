package Var_Comparator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        Comparator<Map.Entry<String, Integer>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> c2 = Comparator.comparing(Map.Entry::getKey);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream   .flatMap(x -> stream(x.split("\\W+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(x -> x, Collectors.summingInt(p -> 1)))
                .entrySet()
                .stream()
//                .sorted(
//                        (e0, e1) -> {
//                            final int res = e1.getValue().compareTo(e0.getValue());
//                            return res == 0 ? e0.getKey().compareTo(e1.getKey()) : res;
//                        }
//                .map(x -> x.getKey())
                .limit(10)
                .forEach(System.out::println);
    }
}

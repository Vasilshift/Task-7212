package Var2_BafferedReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Comparator<Map.Entry<String, Integer>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> c2 = Comparator.comparing(Map.Entry::getKey);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines();
        stream.map(String::toLowerCase)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                //.sorted(c1.thenComparing(c2))
                .map(x -> x.getKey())
                .limit(10)
                .forEach(System.out::println);
    }
}

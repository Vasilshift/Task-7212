package Var1_Scanner_works;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {

//        Comparator<Map.Entry<String, Integer>> e1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
//        Comparator<Map.Entry<String, Integer>> e2 = Comparator.comparing(Map.Entry::getKey);
        Scanner scanner = new Scanner(System.in);
        //Map<String, Integer> mp = new HashMap<>();
        Stream<String> str = scanner.useDelimiter("\\s*(\\s|,|!|-|\\.|\\(|\\)|\\+|\\*|\\/)\\s*").tokens();
        str.map(String::toLowerCase)

                .collect(groupingBy(s -> s, counting())) //#works
                //.collect(Collectors.toMap(k -> k, v -> 1, Integer::sum, HashMap::new))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //.collect(groupingBy(s -> s, counting()))
                //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //.sorted(Map.Entry.comparingByKey(Comparator.comparing()))
                //.sorted(Map.Entry.comparingByValue().reversed()
                //.thenComparing(Map.Entry.comparingByKey()))
                //.(Collectors.toMap(Map.Entry::getKey, Map.entry(e1)::getValue), (e1, e2) -> e1, HashMap::new)
                //.sorted(Comparator.comparing())
                //                .sorted(
                //                        (e1, e2) -> {
                //                            final int res = e1.getValue().compareTo(e1.getValue());
                //                            return res == 0 ? e2.getKey().compareTo(e1.getKey()) : res;
                //                        }
                //                )
                .limit(10)
                .forEach(System.out::println);





    }
}

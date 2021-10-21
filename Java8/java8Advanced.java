import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class java8Advanced {
    public static void main(String[] args) {
        //Steps to sort a Map in Java 8.
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortMap);

        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);
        /*
        Original...
        {a=6, b=5, c=20, d=1, e=7, f=9, g=50, y=8, z=10, m=2, n=99}
        Sorted...
        {a=6, b=5, c=20, d=1, e=7, f=9, g=50, m=2, n=99, y=8, z=10}
        {a=6, b=5, c=20, d=1, e=7, f=9, g=50, m=2, n=99, y=8, z=10}
         */

        Map<String, Integer> result3 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String, Integer> result4 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result3);
        System.out.println(result4);
        //{d=1, m=2, b=5, a=6, e=7, y=8, f=9, z=10, c=20, g=50, n=99}
        //{n=99, g=50, c=20, z=10, f=9, y=8, e=7, a=6, b=5, m=2, d=1}


        /// Filter a Map examples
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");

       //Map -> Stream -> Filter -> String
        String rs = map.entrySet().stream().filter(x -> "linode.com".equals(x.getValue()))
                .map(x -> x.getValue())
                .collect(Collectors.joining());
        System.out.println(rs);
        //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = map.entrySet().stream()
                .filter(x -> x.getKey() == 2)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        System.out.println(collect);
        // or like this
        Map<Integer, String> collecta = map.entrySet().stream()
                .filter(x -> x.getKey() == 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collecta);
        //linode.com
        //{2=heroku.com}
       //{}
    }
}

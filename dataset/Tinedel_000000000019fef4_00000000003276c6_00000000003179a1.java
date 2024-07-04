import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Solution {

    public static class Pair {
        int bound;
        String result;

        public Pair(int bound, String result) {
            this.bound = bound;
            this.result = result;
        }

        public int getBound() {
            return bound;
        }

        public String getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            List<Pair> data = readData(in);
            System.out.println("Case #" + i + ": " + solve(u, data));
        }
    }

    private static String solve(int u, List<Pair> data) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Long> collect = data.stream().map(d -> d.result.charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        StringBuilder str19 = collect.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        Set<Integer> found = str19.chars().boxed().collect(toSet());

        char zero = (char) data.stream().flatMap((Pair pair) -> pair.getResult().chars().boxed())
                .filter(c -> !found.contains(c)).findAny().get().byteValue();
        return sb.append(zero).append(str19).toString();
    }

    private static List<Pair> readData(Scanner in) {
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            res.add(new Pair(in.nextInt(), in.next()));
        }
        res.sort(Comparator.comparing(Pair::getBound));
        return res;
    }
}
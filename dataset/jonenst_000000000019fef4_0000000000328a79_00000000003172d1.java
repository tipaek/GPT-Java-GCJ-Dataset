import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            List<Object> input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static List<Object> readInput(Scanner in) {
        int N = in.nextInt();
        int D = in.nextInt();
        List<Long> slices = new ArrayList<Long>();
        for (int i = 0; i < N; i++) {
            slices.add(in.nextLong());
        }
        return Arrays.asList(N, D, slices);
    }

    public static String solve(List<Object> input) {
        int N = (int) input.get(0);
        int D = (int) input.get(1);
        List<Long> slices = (List<Long>) input.get(2);
        Map<Long, Long> map = slices.stream()
                .collect(Collectors.groupingBy(
                    Function.identity(), 
                    Collectors.counting()));
        long biggest = map.entrySet().stream().mapToLong(e -> e.getValue()).max().getAsLong();
        if ((biggest >= 3 && D == 3) || (biggest >= 2 && D == 2)) {
            return "0";
        }
        if (D == 2) {
            return "1";
        }

        long slicest = map.entrySet().stream().mapToLong(e -> e.getKey()).max().getAsLong();
        if (biggest == 2 && D == 3) {
            for (Entry<Long, Long> e : map.entrySet()) {
                // happens twice, not the largest, cut the largest
                if (e.getValue() == 2) {
                    if (e.getKey() < slicest) {
                        return "1";
                    }
                }
            }
        }

        // look for a , 2*a
        for (Entry<Long, Long> e : map.entrySet()) {
            if (map.containsKey(e.getKey() * 2)) {
                return "1";
            }
        }

        return "2";
    }
}

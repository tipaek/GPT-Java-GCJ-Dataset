import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {


    private static int D;
    private static int N;
    private static List<Long> a;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int[] line = lineToInt(in.nextLine());
            N = line[0];
            D = line[1];
            a = lineToLong(in.nextLine());
            String result = "" + solve(in);

            System.out.println(String.format("Case #%d: %s", i, result));
        }

    }

    private static int solve(Scanner in) {
        Map<Long, Long> freq = a.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if(D ==2){
            if(N == 1) return 1;
            return freq.values().stream().anyMatch(l -> l >=2) ? 0 :1;
        } else {
            if(freq.values().stream().anyMatch(l -> l >=3)) return 0;
            if(freq.values().stream().anyMatch(l -> l >=2)) return 1;
            for (Long l : a) {
                for (Long l2 : a) {
                    if(l == 2*l2) return 1;
                }
            }
            return 2;
        }
    }
    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] lineToInt(String line) {
        return lineToInt(line, " ");
    }

    public static List<Long> lineToLong(String line) {
        return Stream.of(line.split(" ")).map(Long::parseLong).collect(Collectors.toList());
    }
}
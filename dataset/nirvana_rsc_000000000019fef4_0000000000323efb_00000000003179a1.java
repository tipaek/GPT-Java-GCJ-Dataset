import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %s\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public String solve(Scanner in) {
            final int u = in.nextInt();
            in.nextLine();
            final Map<Character, Integer> freq2 = new HashMap<>();
            final Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                final String[] s = in.nextLine().split(" ");
                for(char c: s[1].toCharArray()) {
                    freq2.merge(c, 1, Integer::sum);
                }
            }
            final LinkedHashMap<Character, Integer> collect2 = freq2
                    .entrySet()
                    .stream()
                    .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2,
                                              LinkedHashMap::new));
            StringBuilder sb = new StringBuilder();
            for (Character key : collect2.keySet()) {
                if(sb.length() == 9) {
                    sb.insert(0, key);
                } else {
                    sb.append(key);
                }
            }
            return sb.toString();
        }
    }
}

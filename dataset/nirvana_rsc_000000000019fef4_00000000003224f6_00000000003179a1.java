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
            Map<String, PriorityQueue<Long>> set = new HashMap<>();
            Map<String, Integer> freq = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                String[] s = in.nextLine().split(" ");
                set.computeIfAbsent(s[1], v -> new PriorityQueue<>(Comparator.reverseOrder()))
                   .add(Long.parseLong(s[0]));
                if (set.get(s[1]).size() > 1) {
                    set.get(s[1]).remove();
                }
                freq.merge(s[1], 1, Integer::sum);
            }
            Map<Character, Integer> map = new HashMap<>();
            int i = 1;
            LinkedHashMap<String, Integer> collect = freq
                    .entrySet()
                    .stream()
                    .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2,
                                              LinkedHashMap::new));
            for (String key : collect.keySet()) {
                if (key.length() == 2 && !map.containsKey(key.charAt(1))) {
                    map.put(key.charAt(1), 0);
                }
                for (char c : key.toCharArray()) {
                    if (!map.containsKey(c)) {
                        map.put(c, i);
                        i++;
                    }
                }
            }
            return map.entrySet()
                      .stream()
                      .sorted(Comparator.comparingInt(Entry::getValue))
                      .map(x -> String.valueOf(x.getKey()))
                      .collect(Collectors.joining());
        }
    }
}

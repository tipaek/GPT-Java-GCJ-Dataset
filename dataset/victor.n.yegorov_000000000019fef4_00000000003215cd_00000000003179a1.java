import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }
        System.out.print(sb);
    }

    private static String solve(Scanner sc) {
        int u = sc.nextInt(); // ignored
        int[] count = new int[26];
        int[] countFirst = new int[26];
        for (int i = 0; i < 10000; ++i) {
            BigInteger q = sc.nextBigInteger(); // ignored
            String r = sc.next();
            r.chars().forEach(j -> ++count[j - 'A']);
            ++countFirst[r.charAt(0) - 'A'];
        }
        Map<String, Integer> all = IntStream.rangeClosed('A', 'Z').filter(i -> count[i - 'A'] > 0).boxed()
                .collect(Collectors.toMap(i -> String.valueOf((char) i.intValue()), i -> count[i - 'A']));
        Map<String, Integer> first = IntStream.rangeClosed('A', 'Z').filter(i -> countFirst[i - 'A'] > 0).boxed()
                .collect(Collectors.toMap(i -> String.valueOf((char) i.intValue()), i -> countFirst[i - 'A']));
        List<String> sortedFirst = first.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        List<String> sortedAll = all.entrySet().stream().filter(e -> !first.containsKey(e.getKey()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int n = sortedAll.size() - 1;
        if (n >= 0) {
            sb.append(sortedAll.get(n));
        }
        for (String letter : sortedFirst) {
            sb.append(letter);
        }
        for (int i = 0; i < n; ++i) {
            sb.append(sortedAll.get(i));
        }
        return sb.toString();
    }

}

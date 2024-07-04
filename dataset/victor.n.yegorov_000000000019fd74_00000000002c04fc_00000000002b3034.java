import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static String solve(String prefix, String suffix, Set<String> a) {
        if (a.isEmpty()) {
            return prefix + suffix;
        }
        Map<String, Integer> x = a.stream().collect(Collectors.toMap(u -> u, u -> u.indexOf('*')));
        String maxPrefix = "", maxSuffix = "";
        Set<String> b = new HashSet<>();
        for (Map.Entry<String, Integer> e : x.entrySet()) {
            int i = e.getValue();
            if (i < 0) {
                String s = e.getKey();
                if (maxSuffix.endsWith(s)) {
                    continue;
                }
                if (s.endsWith(maxSuffix)) {
                    maxSuffix = s;
                    continue;
                }
                return "";
            }

            String sub = e.getKey().substring(0, i);
            String rest = e.getKey().substring(i + 1);
            if (!rest.isEmpty()) {
                b.add(rest);
            }
            if (maxPrefix.startsWith(sub)) {
                continue;
            }
            if (sub.startsWith(maxPrefix)) {
                maxPrefix = sub;
                continue;
            }
            return "";
        }
        prefix = prefix + maxPrefix;
        suffix = maxSuffix + suffix;
        return solve(prefix, suffix, b);
    }

    private static String solve(Scanner sc) {
        final Set<String> a = IntStream.range(0, sc.nextInt()).mapToObj(i -> sc.next()).collect(Collectors.toSet());
        return solve("", "", a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output.isEmpty() ? "*" : output).append("\n");
        }

        System.out.print(sb);
    }
}
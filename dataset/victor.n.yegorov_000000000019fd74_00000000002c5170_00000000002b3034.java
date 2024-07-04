import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static String solve(Set<String> a) {
        Map<String, int[]> pos = a.stream().collect(Collectors.toMap(u -> u, u -> new int[]{u.indexOf('*'), u.lastIndexOf('*')}));
        String prefix = "";
        String suffix = "";
        Set<String> res = new HashSet<>();
        for (String s : a) {
            int[] p = pos.get(s);
            int i = p[0], j = p[1];
            String sp = s.substring(0, i);
            if (prefix.isEmpty()) {
                prefix = sp;
            } else if (prefix.startsWith(sp)) {
                //ok
            } else if (sp.startsWith(prefix)) {
                prefix = sp;
            } else {
                return "";
            }

            String ss = s.substring(j + 1);
            if (suffix.isEmpty()) {
                suffix = ss;
            } else if (suffix.endsWith(ss)) {
                //ok
            } else if (ss.endsWith(suffix)) {
                suffix = ss;
            } else {
                return "";
            }

            if (i != j) {
                res.add(s.substring(i + 1, j));
            }
        }

        StringBuilder body = new StringBuilder();
        Set<String> newRes = new HashSet<>();
        while (!res.isEmpty()) {
            newRes.clear();
            for (String s : res) {
                int i = s.indexOf('*');
                if (i >= 0) {
                    body.append(s, 0, i);
                    newRes.add(s.substring(i + 1));
                } else {
                    body.append(s);
                }
            }
            res.addAll(newRes);
        }

        return String.format("%s%s%s", prefix, body, suffix);
    }

    private static String solve(Scanner sc) {
        final Set<String> a = IntStream.range(0, sc.nextInt()).mapToObj(i -> sc.next()).collect(Collectors.toSet());
        return solve(a);
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
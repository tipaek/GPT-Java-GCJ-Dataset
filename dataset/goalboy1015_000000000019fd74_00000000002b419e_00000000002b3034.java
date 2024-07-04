import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int N = sc.nextInt();
            String[] P = new String[N];
            for (int i = 0; i < P.length; ++i) {
                P[i] = sc.next();
            }

            System.out.println(String.format("Case #%d: %s", tc, solve(P)));
        }

        sc.close();
    }

    static String solve(String[] P) {
        List<String> prefixs = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();
        List<String> middles = new ArrayList<>();

        for (String pattern : P) {
            int leftIndex = pattern.indexOf('*');
            prefixs.add(pattern.substring(0, leftIndex));

            int rightIndex = pattern.lastIndexOf('*');
            suffixes.add(pattern.substring(rightIndex + 1));

            String middle = pattern.substring(leftIndex, rightIndex + 1).replaceAll("\\*", "");
            middles.add(middle);
        }

        String prefix = "";
        for (String p : prefixs) {
            if (p.length() > prefix.length()) {
                if (p.startsWith(prefix)) {
                    prefix = p;
                } else {
                    return "*";
                }
            } else if (!prefix.startsWith(p)) {
                return "*";
            }
        }

        String suffix = "";
        for (String s : suffixes) {
            if (s.length() > suffix.length()) {
                if (s.endsWith(suffix)) {
                    suffix = s;
                } else {
                    return "*";
                }
            } else if (!suffix.endsWith(s)) {
                return "*";
            }
        }

        return String.format("%s%s%s", prefix, String.join("", middles), suffix);
    }
}
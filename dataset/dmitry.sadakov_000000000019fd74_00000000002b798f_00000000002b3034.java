
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            String s = solve(in);
            System.out.println("Case #" + i + ": " + (String.join(" ", s)));
        }
    }

    private static String solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        List<String> prefixes  = new ArrayList<>();
        List<String> suffixes  = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] split = str.split("\\*");

            prefixes.add(split[0]);
            if (split.length > 1) {
                suffixes.add(split[1]);
            }
        }

        String suffix = "";
        for(int i = 0; i < suffixes.size(); i++) {
            if (suffix.equals("")) {
                suffix = suffixes.get(0);
                continue;
            }
            // needs to match and be saved if larger
            String s = suffixes.get(i);
            if (s.endsWith(suffix) || suffix.endsWith(s)) {
                if (suffix.length() < s.length()) {
                    suffix = s;
                }
            } else {
                return "*";

            }
        }
        String prefix = "";
        for(int i = 0; i < prefixes.size(); i++) {
            if (prefix.equals("")) {
                prefix = prefixes.get(0);
                continue;
            }
            String p = prefixes.get(i);
            // needs to match and be saved if larger
            if (p.startsWith(prefix) || prefix.startsWith(p)) {
                if (prefix.length() < p.length()) {
                    prefix = p;
                }
            } else {
                return "*";
            }
        }
        return prefix + suffix;
    }
}


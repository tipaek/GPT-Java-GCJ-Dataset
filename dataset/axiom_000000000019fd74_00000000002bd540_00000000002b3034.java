import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                String p = in.next();
                patterns[j] = p;
            }
            String res = solve(patterns);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(String[] patterns) {
        String prefix = "";
        String appdendix = "";

        List<List<String>> ps = new ArrayList<List<String>>(patterns.length);
        for (int i = 0; i < patterns.length; i++) {
            String[] p = patterns[i].split("\\*");
            List<String> asList = new ArrayList<>();
            for (int k = 0; k < p.length; k++) {
                asList.add(p[k]);
            }
            if (patterns[i].endsWith("*")) {
                asList.add("");
            }
            ps.add(asList);
            if (asList.get(0).length() > prefix.length()) {
                prefix = asList.get(0);
            }
            if (asList.get(asList.size() - 1).length() > appdendix.length()) {
                appdendix = asList.get(asList.size() - 1);
            }
        }

        List<String> mid = new ArrayList<>();
        int len = prefix.length() + appdendix.length();

        for (int i = 0; i < patterns.length; i++) {
            List<String> pattern = ps.get(i);
            String pre = pattern.get(0);
            String sub = pattern.get(pattern.size() - 1);
            if (!prefix.startsWith(pre)) {
                return "*";
            }
            if (!appdendix.endsWith(sub)) {
                return "*";
            }

            for (int j = 1; j < pattern.size() - 1; j++) {
                String p = pattern.get(j);
                int find = 0;
                for (int k = 0; k < mid.size(); k++) {
                    String pp = mid.get(k);
                    if (pp.indexOf(p) > 0) {
                        find = 1;
                        break;
                    }
                    if (p.indexOf(pp) > 0) {
                        find = 2;
                        mid.set(k, p);
                        len += (p.length() - pp.length());
                        break;
                    }
                }
                if (find == 0) {
                    mid.add(p);
                    len += p.length();
                } else if (find == 1) {
                } else if (find == 2) {
                }
                if (len > 10000) {
                    return "*";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < mid.size(); i++) {
            sb.append(mid.get(i));
        }
        sb.append(appdendix);
        return sb.toString();
    }
}

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] pattern = new String[n];
            for (int j = 0; j < n; j++) {
                pattern[j] = sc.next();
            }
            String res = solve(pattern);
            System.out.println("Case #" + (i+1) + ": " + res);
        }
    }

    private static String solve(String[] patterns) {
        String start = "";
        String end = "";
        for (int i = 0; i < patterns.length; i++) {
            String[] current = split(patterns[i]);
            String cS = current[0];
            String cE = current[1];
            start = buildStart(cS,start);
            end = buildEnd(cE,end);
            if(start.equals("*") || end.equals("*")) return "*";
        }
        return start + end;
    }

    private static String[] split(String s) {
        int i = s.indexOf("*");
        if (i == 0) {
            return new String[]{"",s.substring(1)};
        }
        if (i == s.length()-1) {
            return new String[] {s.substring(0, s.length()-1), ""};
        }
        return s.split("\\*");
    }

    private static String buildStart(String cs, String start) {
        String max = cs.length() > start.length() ? cs : start;
        String min = cs.length() > start.length() ? start : cs;
        if(max.startsWith(min)) {
            return max;
        }
        else return "*";
    }

    private static String buildEnd(String ce, String end) {
        String max = ce.length() > end.length() ? ce : end;
        String min = ce.length() > end.length() ? end : ce;
        if(max.endsWith(min)) {
            return max;
        }
        else return "*";

    }

    static int[] read(int n, Scanner sc) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }
}

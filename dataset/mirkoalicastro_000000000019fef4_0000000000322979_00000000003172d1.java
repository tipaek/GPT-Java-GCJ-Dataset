import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int testCases = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=testCases; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            ArrayList<String> s = new ArrayList<>(n);
            for (int j=0; j<n; j++)
                s.add(scanner.next());
//            System.out.println(n + " " + d + ":");
            String sol = solveEasy(n, d, s);
            sb.append("Case #").append(i).append(": ").append(sol).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static String solveEasy(int n, int d, ArrayList<String> s) {
        Collections.sort(s);
//        System.out.println(s);
        boolean opt = isOpt(d, s);
        if (opt)
            return "0";
        if (s.size() == 1) {
            return String.valueOf(d-1);
        }
        return solve(n, d, s);
    }

    private static String solve(int n, int d, ArrayList<String> s) {
        if (d == 3) {
            if (allEquals(s))
                return "2";
        }
        return "1";
    }

    private static boolean isOpt(int d, ArrayList<String> s) {
        if (s.size() < d)
            return false;
        String first = s.get(0);
        int from = 0;
        for (int i=1; i<s.size(); i++) {
            if (!s.get(i).equals(first)) {
                from = 0;
                first = s.get(i);
            } else {
                from++;
                if (from == d-1)
                    return true;
            }
        }
        return false;
    }

    private static boolean allEquals(ArrayList<String> s) {
        String first = s.get(0);
        for (int i=1; i<s.size(); i++) {
            if (!s.get(i).equals(first)) {
                return false;
            }
        }
        return true;
    }

}
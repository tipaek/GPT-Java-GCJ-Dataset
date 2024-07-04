import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            ArrayList<Double> s = new ArrayList<>(n);
            for (int j=0; j<n; j++)
                s.add((double) scanner.nextLong());
     //       System.out.println(n + " " + d + ":");
            String sol = solveEasy(n, d, s);
            sb.append("Case #").append(i).append(": ").append(sol).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static String solveEasy(int n, int d, ArrayList<Double> s) {
        Collections.sort(s);
        boolean opt = isOpt(d, s);
        if (opt)
            return "0";
        if (s.size() == 1) {
            return String.valueOf(d-1);
        }
        return solve(n, d, s);
    }

    private static String solve(int n, int d, ArrayList<Double> s) {
        return "1";
    }

    private static boolean isOpt(int d, List<Double> s) {
        if (s.size() < d)
            return false;
        double first = s.get(0);
        int from = 0;
        for (int i=1; i<s.size(); i++) {
            if (s.get(i) != first) {
                from = i;
                first = s.get(i);
            } else {
                from++;
                if (from == d)
                    return true;
            }
        }
        return false;
    }

}
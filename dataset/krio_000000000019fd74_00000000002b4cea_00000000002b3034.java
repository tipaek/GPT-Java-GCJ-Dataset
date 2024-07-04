import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String[] P = new String[N];
            for (int j = 0; j < N; j++) {
                P[j] = in.next();
            }
            System.out.println("Case #" + i + ": " + solve(P, N));
        }
    }

    private static String solve(String[] P, int N) {
        String left = "", right = "";
        for (String pattern : P) {
            String[] tokens = pattern.split("\\*");

            if (tokens.length == 2) {
                if ((left = matchLeft(left, tokens[0])) == null) return "*";

                if ((right = matchRight(right, tokens[1])) == null) return "*";
            } else if (pattern.charAt(0) == '*') {
                if ((right = matchRight(right, tokens[0])) == null) return "*";
            } else {
                if ((left = matchLeft(left, tokens[0])) == null) return "*";
            }
        }
        return left + right;
    }

    private static String matchLeft(String left, String pattern) {
        if (left.length() == 0) return pattern;

        if (left.length() >= pattern.length() && left.startsWith(pattern)) return left;

        if (left.length() < pattern.length() && pattern.startsWith(left)) return pattern;

        return null;
    }

    private static String matchRight(String right, String pattern) {
        if (right.length() == 0) return pattern;

        if (right.length() >= pattern.length() && right.endsWith(pattern)) return right;

        if (right.length() < pattern.length() && pattern.endsWith(right)) return pattern;

        return null;
    }

}

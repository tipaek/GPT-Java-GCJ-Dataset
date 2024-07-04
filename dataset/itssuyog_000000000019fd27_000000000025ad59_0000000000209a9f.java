import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            String solution = solve(input);
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static String solve(String input) {
        String sol = "";
        int curr = 0;
        int diff = 0;
        for (int i = 0; i < input.length(); i++) {
            int x = Character.getNumericValue(input.charAt(i));
            diff = x - curr;
            curr = curr + diff;
            sol += getParanthesis(diff);
            sol += x;
        }
        sol += getParanthesis(-curr);
        return sol;
    }

    private static String getParanthesis(int diff) {
        String p = "";
        if (diff < 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                p += ")";
            }
        }
        if (diff > 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                p += "(";
            }
        }
        return p;
    }
}
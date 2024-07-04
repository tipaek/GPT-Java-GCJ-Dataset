
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            System.out.println("Case #" + i + ": " + solve(input));
        }
    }

    public static String solve(String input) {
        String result = "";
        int curr = 0;

        for(int i = 0; i < input.length(); i++){
            int val = input.charAt(i) - '0';
            if (curr >= val) {
                result += addParenthesis(")", curr - val) + val;
            }
            else {
                result += addParenthesis("(",  val - curr) + val;
            }
            curr = val;
        }

        result += addParenthesis(")", curr);
        return result;
    }

    private static String addParenthesis(String s, int n) {
        String res = "";
        for(int i = 0; i < n; i++) res += s;
        return res;
    }
}

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            solve(i, in.next());
        }
    }

    private static void solve(int caseNumber, String digits) {
        int openBrackets = 0;
        StringBuilder result = new StringBuilder();
        for (char c : digits.toCharArray()) {
            int digit = c - '0';
            if (digit == openBrackets) {
                result.append(c);
            } else if (digit > openBrackets) {
                for (int i = 0; i < digit - openBrackets; i++) {
                    result.append('(');
                }
            } else {
                for (int i = 0; i < openBrackets - digit; i++) {
                    result.append(')');
                }
            }
            openBrackets = digit;
        }
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= n; i++) {
            solveIt(in, i);
        }
    }

    private static void solveIt(Scanner in, int idx) {
        String str = in.next();
        StringBuilder result = new StringBuilder();
        char lastChar = '0';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0' && lastChar == '1') {
                result.append(')');
            } else if (c == '1' && lastChar == '0') {
                result.append('(');
            }
            result.append(c);
            lastChar = c;
        }
        if (lastChar == '1') result.append(')');
        System.out.println("Case #" + idx + ": " + result.toString());
    }
}

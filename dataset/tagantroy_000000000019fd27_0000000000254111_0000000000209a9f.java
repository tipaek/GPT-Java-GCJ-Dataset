
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; ++t) {
            String input = in.next();

            String result = solve(input);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '0') {
                if (open > 0) {
                    sb.append(')');
                    open--;
                }
                sb.append(ch);
            }
            if (ch != '0') {
                if (open > 0) {
                    sb.append(ch);
                } else {
                    sb.append('(');
                    open++;
                    sb.append(ch);
                }
            }
        }
        if (open > 0) {
            sb.append(')');
        }
        return sb.toString();
    }
}
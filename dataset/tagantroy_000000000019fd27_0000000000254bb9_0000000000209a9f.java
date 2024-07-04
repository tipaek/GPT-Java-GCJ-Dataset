

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
        int level = 0;
        for (int i = 0; i < input.length(); i++) {
            int d = input.charAt(i) - '0';
            while (level < d) {
                sb.append('(');
                level++;
            }
            while (level > d) {
                sb.append(')');
                level--;
            }
            sb.append(d);
        }
        while (level > 0) {
            sb.append(')');
            level--;
        }
        return sb.toString();
    }
}
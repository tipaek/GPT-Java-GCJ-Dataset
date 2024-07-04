import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String input = in.next();
            StringBuilder output = new StringBuilder();
            int depth = 0;
            for (int i = 0; i < input.length(); i++) {
                int x = input.charAt(i) - '0';
                if (x > depth) {
                    for (int j = depth; j < x; j++) {
                        output.append("(");
                    }
                } else if (x < depth) {
                    for (int j = x; j < depth; j++) {
                        output.append(")");
                    }
                }
                depth = x;
                output.append(input.charAt(i));
            }
            for (int i = 0; i < depth; i++) {
                output.append(")");
            }
            System.out.println("Case #" + t + ": " + output.toString());
        }
    }
}

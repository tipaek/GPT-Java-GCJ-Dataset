import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String input = in.next();

            int prevDepth = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : input.toCharArray()) {
                int currentDepth = Character.getNumericValue(c);

                if (currentDepth > prevDepth) {
                    for (int j = 0; j < currentDepth - prevDepth; j++) {
                        sb.append("(");
                    }
                } else if (prevDepth > currentDepth) {
                    for (int j = 0; j < prevDepth - currentDepth; j++) {
                        sb.append(")");
                    }
                }

                sb.append(c);

                prevDepth = currentDepth;
            }

            for (int j = 0; j < prevDepth; j++) {
                sb.append(")");
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}

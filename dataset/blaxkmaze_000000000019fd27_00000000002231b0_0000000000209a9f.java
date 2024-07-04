import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String input) {
        StringBuilder builder = new StringBuilder();

        int leftOpenBrakets = 0;
        for (char c : input.toCharArray()) {
            int i = c - '0';
            larger: while (i > leftOpenBrakets) {
                if (leftOpenBrakets > 0) {
                    builder.append(')');
                    leftOpenBrakets--;
                    continue larger;
                }
                builder.append('(');
                leftOpenBrakets++;
            }

            while (i < leftOpenBrakets) {
                builder.append(')');
                leftOpenBrakets--;
            }

            builder.append(c);
        }

        while (leftOpenBrakets-- > 0)
            builder.append(')');

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = Integer.valueOf(in.nextInt()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSize; ++i) {
            String input = in.nextLine();
            String output = nestingDepth(input);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #" + i + ": ");
            builder.append(output);
            System.out.println(builder.toString().trim());
        }
    }
}
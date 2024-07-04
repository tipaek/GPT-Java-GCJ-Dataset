import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            final StringBuilder solution = new StringBuilder();
            final String original = input.next();

            int currentDepth = 0;
            for(int i = 0; i < original.length(); ++i) {
                int digit = original.charAt(i) - '0';

                for(int p = currentDepth; p < digit; ++p) {
                    solution.append('(');
                }

                for(int p = currentDepth; p > digit; --p) {
                    solution.append(')');
                }

                currentDepth = digit;
                solution.append(original.charAt(i));
            }

            for(int p = currentDepth; p > 0; --p) {
                solution.append(')');
            }

            System.out.println(String.format("Case #%d: %s", t, solution));
        }
    }
}
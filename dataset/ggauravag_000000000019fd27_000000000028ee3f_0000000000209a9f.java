

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            final String input = scanner.nextLine();
            final StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            for (int j = 0; j < input.length(); j++) {
                final int digit = Character.getNumericValue(input.charAt(j));
                if (currentDepth > digit) {
                    output.append(repeat(")", currentDepth - digit));
                    currentDepth = digit;
                } else if (currentDepth < digit) {
                    output.append(repeat("(", digit - currentDepth));
                    currentDepth = digit;
                }

                output.append(digit);
            }

            for (int k = 0; k < currentDepth; k++) {
                output.append(")");
            }

            System.out.println(String.format("Case #%d: %s", i, output.toString()));
        }

        scanner.close();
    }

    private static String repeat(String ch, int depth) {
        final StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            repeated.append(ch);
        }

        return repeated.toString();
    }

}

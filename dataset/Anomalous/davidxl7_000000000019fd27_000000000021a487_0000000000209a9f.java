import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String input = reader.readLine();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));

                if (digit > currentDepth) {
                    for (int k = currentDepth; k < digit; k++) {
                        System.out.print("(");
                    }
                } else if (digit < currentDepth) {
                    for (int k = currentDepth; k > digit; k--) {
                        System.out.print(")");
                    }
                }

                currentDepth = digit;
                System.out.print(digit);
            }

            for (int k = currentDepth; k > 0; k--) {
                System.out.print(")");
            }

            if (i != testCases - 1) {
                System.out.println();
            }
        }
    }
}
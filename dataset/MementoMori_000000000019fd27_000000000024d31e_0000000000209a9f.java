import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String OPEN = "(";
    private static final String CLOSE = ")";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();
        in.nextLine();
        for (int k = 1; k <= numberOfTestCases; ++k) {
            String input = in.nextLine();
            final StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            for (int i = 0; i < input.length(); i++) {
                final char currentChar = input.charAt(i);
                final int currentNumber = Integer.parseInt(String.valueOf(currentChar));
                if (currentNumber > currentDepth) {
                    for (int j = 0; j < currentNumber - currentDepth; j++) {
                        result.append(OPEN);
                    }
                    result.append(currentChar);
                } else if (currentNumber < currentDepth) {
                    for (int j = 0; j < currentDepth - currentNumber; j++) {
                        result.append(CLOSE);
                    }
                    result.append(currentChar);
                } else {
                    result.append(currentChar);
                }
                currentDepth = currentNumber;
            }
            for (int j = 0; j < currentDepth; j++) {
                result.append(CLOSE);
            }
            System.out.println(String.format("Case #%d: %s", k, result.toString()));
        }
    }
}
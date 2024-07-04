import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);

        int testCases = Integer.parseInt(reader.readLine().trim());
        for (int i = 1; i <= testCases; i++) {
            String inputString = reader.readLine().trim();
            String result = processString(inputString);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';

            if (digit == currentDepth) {
                resultBuilder.append(digit);
            } else if (digit < currentDepth) {
                int difference = currentDepth - digit;
                currentDepth = digit;
                for (int j = 0; j < difference; j++) {
                    resultBuilder.append(")");
                }
                resultBuilder.append(digit);
            } else {
                int difference = digit - currentDepth;
                currentDepth = digit;
                for (int j = 0; j < difference; j++) {
                    resultBuilder.append("(");
                }
                resultBuilder.append(digit);
            }
        }

        for (int i = 0; i < currentDepth; i++) {
            resultBuilder.append(")");
        }

        return resultBuilder.toString();
    }
}
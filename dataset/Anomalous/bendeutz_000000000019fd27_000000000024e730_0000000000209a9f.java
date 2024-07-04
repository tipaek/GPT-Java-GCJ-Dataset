import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int prevNumber = Character.getNumericValue(input.charAt(0));
            appendBraces(result, prevNumber, prevNumber);

            for (int j = 1; j < input.length(); j++) {
                int currentNumber = Character.getNumericValue(input.charAt(j));
                if (prevNumber != currentNumber) {
                    appendBraces(result, prevNumber, currentNumber);
                    prevNumber = currentNumber;
                }
                result.append(currentNumber);
            }
            appendBraces(result, prevNumber, 0);

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }

    private static void appendBraces(StringBuilder result, int open, int close) {
        int diff = open - close;
        if (diff > 0) {
            for (int k = 0; k < diff; k++) {
                result.append(')');
            }
        } else {
            for (int k = 0; k < -diff; k++) {
                result.append('(');
            }
        }
    }
}
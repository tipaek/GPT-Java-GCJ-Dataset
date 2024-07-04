import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = calculateNestingDepth(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String calculateNestingDepth(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int previousDepth = 0;

        for (char character : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(character);
            resultBuilder.append(generateEnclosedDepth(previousDepth, currentDepth));
            resultBuilder.append(character);
            previousDepth = currentDepth;
        }

        // Close any remaining open parentheses
        resultBuilder.append(generateEnclosedDepth(previousDepth, 0));

        return resultBuilder.toString();
    }

    public static String generateEnclosedDepth(int previousDepth, int currentDepth) {
        StringBuilder depthBuilder = new StringBuilder();
        int difference = currentDepth - previousDepth;

        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                depthBuilder.append('(');
            }
        } else {
            for (int i = 0; i < -difference; i++) {
                depthBuilder.append(')');
            }
        }

        return depthBuilder.toString();
    }
}
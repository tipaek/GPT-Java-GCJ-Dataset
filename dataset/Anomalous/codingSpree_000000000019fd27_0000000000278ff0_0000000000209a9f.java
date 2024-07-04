import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = generateMinimumNestingDepthString(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String generateMinimumNestingDepthString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int previousDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDepth = Character.getNumericValue(input.charAt(i));

            if (currentDepth > previousDepth) {
                for (int j = previousDepth; j < currentDepth; j++) {
                    resultBuilder.append('(');
                }
            } else if (currentDepth < previousDepth) {
                for (int j = previousDepth; j > currentDepth; j--) {
                    resultBuilder.append(')');
                }
            }

            resultBuilder.append(currentDepth);
            previousDepth = currentDepth;
        }

        for (int i = 0; i < previousDepth; i++) {
            resultBuilder.append(')');
        }

        return resultBuilder.toString();
    }
}
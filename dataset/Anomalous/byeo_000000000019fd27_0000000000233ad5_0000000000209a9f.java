import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String line) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : line.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            int depthDifference = digit - currentDepth;

            if (depthDifference > 0) {
                result.append(repeatChar('(', depthDifference));
            } else if (depthDifference < 0) {
                result.append(repeatChar(')', -depthDifference));
            }

            result.append(digit);
            currentDepth = digit;
        }

        result.append(repeatChar(')', currentDepth));
        return result.toString();
    }

    public static void main(String[] args) {
        String[] testCases = readInput();
        for (int i = 0; i < testCases.length; i++) {
            String output = nestingDepth(testCases[i]);
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    private static String repeatChar(char ch, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(ch);
        }
        return repeated.toString();
    }

    private static String[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] inputs = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            inputs[i] = scanner.nextLine();
        }
        return inputs;
    }
}
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                String input = scanner.next();
                System.out.println("Case #" + (i + 1) + ": " + generateNestingDepthString(input));
            }
        }
    }

    public static String generateNestingDepthString(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char character : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(character);

            if (currentDepth > previousDepth) {
                appendCharacters(result, '(', currentDepth - previousDepth);
            } else if (currentDepth < previousDepth) {
                appendCharacters(result, ')', previousDepth - currentDepth);
            }

            result.append(currentDepth);
            previousDepth = currentDepth;
        }

        appendCharacters(result, ')', previousDepth);
        return result.toString();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}
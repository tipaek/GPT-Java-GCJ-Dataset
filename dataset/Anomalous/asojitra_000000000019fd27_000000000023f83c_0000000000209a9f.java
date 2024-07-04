import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                String input = scanner.next();
                System.out.println("Case #" + (i + 1) + " " + createNestingDepthString(input));
            }
        }
    }

    public static String createNestingDepthString(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char digit : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(digit);

            if (currentDepth > previousDepth) {
                appendCharacters(result, '(', currentDepth - previousDepth);
            } else if (currentDepth < previousDepth) {
                appendCharacters(result, ')', previousDepth - currentDepth);
            }

            result.append(digit);
            previousDepth = currentDepth;
        }

        appendCharacters(result, ')', previousDepth);
        return result.toString();
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}
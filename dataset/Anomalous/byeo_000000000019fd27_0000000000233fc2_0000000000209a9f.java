import java.util.Scanner;

public class Solution {

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digit : input.toCharArray()) {
            int numericValue = Character.getNumericValue(digit);
            int depthDifference = numericValue - currentDepth;

            if (depthDifference > 0) {
                result.append(repeatCharacter('(', depthDifference));
            } else if (depthDifference < 0) {
                result.append(repeatCharacter(')', -depthDifference));
            }

            result.append(numericValue);
            currentDepth = numericValue;
        }

        result.append(repeatCharacter(')', currentDepth));
        return result.toString();
    }

    public static void main(String[] args) {
        String[] testCases = getInput();
        for (int i = 0; i < testCases.length; i++) {
            String output = calculateNestingDepth(testCases[i]);
            System.out.printf("Case #%d: %s%n", i + 1, output);
        }
    }

    private static String repeatCharacter(char character, int count) {
        StringBuilder repeatedCharacters = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedCharacters.append(character);
        }
        return repeatedCharacters.toString();
    }

    private static String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String[] inputs = new String[numberOfCases];

        for (int i = 0; i < numberOfCases; i++) {
            inputs[i] = scanner.nextLine();
        }

        return inputs;
    }
}
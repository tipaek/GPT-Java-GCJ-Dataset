import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            List<Integer> numbers = parseInput(scanner.nextLine());
            System.out.println("Case #" + (caseIndex + 1) + ": " + generateNestedParentheses(numbers));
        }
    }

    private static List<Integer> parseInput(String input) {
        return input.chars()
                    .map(Character::getNumericValue)
                    .boxed()
                    .collect(Collectors.toList());
    }

    private static StringBuilder generateNestedParentheses(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int number : numbers) {
            if (number > currentDepth) {
                appendCharacters(result, '(', number - currentDepth);
                currentDepth = number;
            } else if (number < currentDepth) {
                appendCharacters(result, ')', currentDepth - number);
                currentDepth = number;
            }
            result.append(number);
        }

        appendCharacters(result, ')', currentDepth);
        return result;
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}
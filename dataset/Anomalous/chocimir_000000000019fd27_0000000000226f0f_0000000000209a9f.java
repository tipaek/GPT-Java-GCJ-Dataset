import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void appendCharacters(StringBuilder result, int count, char character) {
        for (int i = 0; i < count; ++i) {
            result.append(character);
        }
    }

    public String solve(String input, int nestingLevel) {
        if (input.isEmpty()) {
            return input;
        }

        char minChar = findMinimumCharacter(input);
        int newNestingLevel = minChar - '0';
        StringBuilder result = new StringBuilder();
        appendCharacters(result, newNestingLevel - nestingLevel, '(');

        StringBuilder nextPart = new StringBuilder();
        for (char currentChar : input.toCharArray()) {
            if (currentChar != minChar) {
                nextPart.append(currentChar);
            } else {
                result.append(solve(nextPart.toString(), newNestingLevel));
                result.append(currentChar);
                nextPart = new StringBuilder();
            }
        }

        result.append(solve(nextPart.toString(), newNestingLevel));
        appendCharacters(result, newNestingLevel - nestingLevel, ')');
        return result.toString();
    }

    private char findMinimumCharacter(String input) {
        char minChar = '9';
        for (char character : input.toCharArray()) {
            if (character < minChar) {
                minChar = character;
            }
        }
        return minChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + solution.solve(input, 0));
        }
    }
}
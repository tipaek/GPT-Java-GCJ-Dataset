import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static void appendCharacters(StringBuilder builder, int count, char character) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }

    private static void adjustParentheses(int previous, int current, StringBuilder builder) {
        if (previous == Integer.MIN_VALUE) {
            appendCharacters(builder, current, '(');
        } else if (current == Integer.MAX_VALUE) {
            appendCharacters(builder, previous, ')');
            return;
        } else if (previous > current) {
            appendCharacters(builder, previous - current, ')');
        } else if (previous < current) {
            appendCharacters(builder, current - previous, '(');
        }
        builder.append(current);
    }

    private static void solveCase(Scanner scanner, int caseNumber) {
        StringBuilder builder = new StringBuilder(102400);
        builder.append("Case #").append(caseNumber).append(": ");

        String input = scanner.next();
        char[] characters = input.toCharArray();

        adjustParentheses(Integer.MIN_VALUE, Character.getNumericValue(characters[0]), builder);

        int length = characters.length - 1;
        for (int i = 1; i < length; i++) {
            adjustParentheses(Character.getNumericValue(characters[i - 1]), Character.getNumericValue(characters[i]), builder);
        }

        if (length > 0) {
            adjustParentheses(Character.getNumericValue(characters[length - 1]), Character.getNumericValue(characters[length]), builder);
        }
        adjustParentheses(Character.getNumericValue(characters[length]), Integer.MAX_VALUE, builder);

        System.out.println(builder.toString());
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            solveCase(scanner, i);
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(final String[] args) {

        final List<String> testCases = parseInput();
        for (int index = 0; index < testCases.size(); index++) {
            System.out.println(String.format("Case #%d: %s", index + 1, buildNestedString(testCases.get(index))));
        }
    }

    private static String buildNestedString(final String input) {
        final StringBuilder builder = new StringBuilder();
        final char initChar = input.charAt(0);
        fillChars(builder, '(', initChar - '0');
        builder.append(initChar);

        for (int index = 1; index < input.length(); index++) {
            final char value = input.charAt(index);
            final char prevValue = input.charAt(index - 1);
            if (value > prevValue) {
                fillChars(builder, '(', value - prevValue);
            } else if (value < prevValue) {
                fillChars(builder, ')', prevValue - value);
            }
            builder.append(value);
        }
        for (int index = 0; index < input.charAt(input.length() - 1) - '0'; index++) {
            builder.append(')');
        }

        return builder.toString();
    }

    private static void fillChars(final StringBuilder builder, final char fill, final int count) {
        for (int index = 0; index < count; index++) {
            builder.append(fill);
        }
    }

    private static List<String> parseInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            String readLine = scanner.nextLine();
            final int numTestCases = Integer.parseInt(readLine);
            final List<String> testCases = new ArrayList<>(numTestCases);

            for (int index = 0; index < numTestCases && null != (readLine = scanner.nextLine()); index++) {
                testCases.add(readLine);
            }

            return testCases;
        }
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(final String[] args) {

        final List<String> testCases = parseInput();
        // final List<String> testCases = Arrays.asList("-", "-+", "+-", "+++", "--+-");
        for (int index = 0; index < testCases.size(); index++) {

            final StringBuilder result = new StringBuilder();

            final String input = testCases.get(index);
            int pos = 0;
            while (pos < input.length()) {
                final int endPos = identifyPartitionLocation(testCases.get(index), pos);
                final String nestedDepthString = nestedDepthString(input, pos, endPos);
                result.append(nestedDepthString);
                pos = endPos;
            }

            System.out.println(String.format("Case #%d: %s", index + 1, result.toString()));
        }
    }

    private static int identifyPartitionLocation(final String input, final int scanLocation) {
        for (int index = scanLocation; index < input.length() - 1; index++) {
            if (input.charAt(index) != input.charAt(index + 1)) {
                return index + 1;
            }
        }

        return input.length();
    }

    private static String nestedDepthString(final String input, final int from, final int to) {
        final String nestedDigits = input.substring(from, to);
        final int value = nestedDigits.charAt(0) - '0';
        if (value == 0) {
            return nestedDigits;
        }

        final StringBuilder builder = new StringBuilder();
        for (int index = 0; index < value; index++) {
            builder.append('(');
        }
        builder.append(nestedDigits);
        for (int index = 0; index < value; index++) {
            builder.append(')');
        }

        return builder.toString();
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


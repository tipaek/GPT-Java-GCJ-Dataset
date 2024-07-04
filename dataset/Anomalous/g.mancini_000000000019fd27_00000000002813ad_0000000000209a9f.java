import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        processInput(Solution::computeNestingDepth);
        System.exit(0);
    }

    private static void processInput(Function<Scanner, String> lineProcessor) {
        Scanner scanner = new Scanner(System.in);
        long numberOfTestCases = scanner.nextLong();

        for (int i = 0; i < numberOfTestCases; i++) {
            displayResult(i + 1, lineProcessor.apply(scanner));
        }
    }

    private static String computeNestingDepth(Scanner scanner) {
        String input = scanner.next();
        List<String> output = new ArrayList<>();
        int currentDepth = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            int depthDifference = digit - currentDepth;

            if (depthDifference > 0) {
                for (int i = 0; i < depthDifference; i++) {
                    output.add("(");
                }
            } else if (depthDifference < 0) {
                for (int i = 0; i < -depthDifference; i++) {
                    output.add(")");
                }
            }

            output.add(String.valueOf(digit));
            currentDepth = digit;
        }

        for (int i = 0; i < currentDepth; i++) {
            output.add(")");
        }

        return output.stream().collect(Collectors.joining());
    }

    private static void displayResult(long caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        solve(Solution::solveNestingDepthLine);
        System.exit(0);
    }

    private static void solve(Function<Scanner, String> solveLine) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int i = 0; i < testCases; i++) {
                String result = solveLine.apply(scanner);
                System.out.printf("Case #%d: %s%n", i + 1, result);
            }
        }
    }

    private static String solveNestingDepthLine(Scanner scanner) {
        String input = scanner.next();
        StringBuilder result = new StringBuilder();
        int prevDepth = 0;

        for (char ch : input.toCharArray()) {
            int currentDepth = ch - '0';

            while (prevDepth < currentDepth) {
                result.append('(');
                prevDepth++;
            }

            while (prevDepth > currentDepth) {
                result.append(')');
                prevDepth--;
            }

            result.append(ch);
        }

        while (prevDepth > 0) {
            result.append(')');
            prevDepth--;
        }

        return result.toString();
    }
}
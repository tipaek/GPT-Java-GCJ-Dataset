import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SolutionQ2 {
    private static final PrintStream output = System.out;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                char[] inputChars = scanner.nextLine().toCharArray();
                StringBuilder result = new StringBuilder();
                int currentDepth = 0;

                for (char ch : inputChars) {
                    int digit = ch - '0';

                    while (currentDepth < digit) {
                        result.append('(');
                        currentDepth++;
                    }

                    while (currentDepth > digit) {
                        result.append(')');
                        currentDepth--;
                    }

                    result.append(ch);
                }

                while (currentDepth > 0) {
                    result.append(')');
                    currentDepth--;
                }

                output.printf("Case #%d: %s%n", caseIndex + 1, result.toString());
            }
        }
    }
}
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String solve(Scanner scanner) {
        String input = scanner.next();
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (digit > currentDepth) {
                output.append('(');
                currentDepth++;
            }

            while (digit < currentDepth) {
                output.append(')');
                currentDepth--;
            }

            output.append(ch);
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }

        return output.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Scanner scanner = new Scanner(new FileInputStream("A.in"));

        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            String result = solve(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, result));
        }
    }
}
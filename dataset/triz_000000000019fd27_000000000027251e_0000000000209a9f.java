import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < tests; i++) {
            int [] line = parseOne(scanner);
            String sol = solve(line);
            System.out.println(String.format("Case #%d: %s", i+1, sol ));
        }
    }

    private static int[] parseOne(Scanner scanner) {
        String line = scanner.nextLine();
        int[] result = new int[line.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = line.charAt(i) - '0';
        }
        return result;
    }

    private static String solve(int []input) {
        StringBuilder solutionBuilder = new StringBuilder();
        int depthOfBrackets = 0;
        for (int i : input) {
            int diff = i - depthOfBrackets;
            if (diff != 0) {
                char bracket = diff > 0 ? '(' : ')';
                for (int j = 0; j < Math.abs(diff); j++) {
                    solutionBuilder.append(bracket);
                }
                depthOfBrackets += diff;
            }
            solutionBuilder.append(i);
        }
        for (int i = 0; i < depthOfBrackets; i++) {
            solutionBuilder.append(')');
        }
        return solutionBuilder.toString();
    }

    private static class Sol {

    }
}

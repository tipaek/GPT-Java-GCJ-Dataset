import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= n; ++testCase) {
            String line = scanner.nextLine();
            printResult(testCase, solve(line));
        }
    }

    private static String solve(String line) {
        StringBuilder output = new StringBuilder();
        int numOpen = 0;
        int previous = 0;
        for (int index = 0; index < line.length(); ++index) {
            int digit = Character.digit(line.charAt(index), 10);

            int diff = previous - digit;
            previous = digit;

            numOpen -= diff;
            if (diff < 0) {
                for (int i = 0; i < Math.abs(diff); ++i) {
                    output.append("(");
                }
            } else if (diff > 0) {
                for (int i = 0; i < diff; ++i) {
                    output.append(")");
                }
            }
            output.append(digit);
        }

        for (int i = 0; i < numOpen; ++i) {
            output.append(")");
        }

        return output.toString();
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}
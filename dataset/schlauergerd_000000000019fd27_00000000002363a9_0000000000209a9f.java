import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();

        for (int test = 1; test <= tests; test++) {
            String result = runSingleTest(scanner);
            System.out.printf("Case #%d: %s%n", test, result);
        }
    }

    public static String runSingleTest(Scanner scanner) {
        StringBuilder result = new StringBuilder();

        int openParenthesis = 0;
        for (char c : scanner.nextLine().toCharArray()) {
            int i = c - 48;

            while (openParenthesis < i) {
                result.append('(');
                openParenthesis++;
            }

            while (openParenthesis > i) {
                result.append(')');
                openParenthesis--;
            }

            result.append(i);
        }

        while (openParenthesis > 0) {
            result.append(')');
            openParenthesis--;
        }

        return result.toString();
    }
}
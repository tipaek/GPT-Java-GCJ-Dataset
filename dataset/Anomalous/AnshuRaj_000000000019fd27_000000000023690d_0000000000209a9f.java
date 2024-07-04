import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                String problemData = scanner.next();
                solveCase(i, problemData);
            }
        }
    }

    private static void solveCase(int testCaseNumber, String data) {
        int openParentheses = 0;
        StringBuilder solution = new StringBuilder();

        for (char ch : data.toCharArray()) {
            int currentDigit = ch - '0';

            while (openParentheses < currentDigit) {
                solution.append('(');
                openParentheses++;
            }

            while (openParentheses > currentDigit) {
                solution.append(')');
                openParentheses--;
            }

            solution.append(currentDigit);
        }

        while (openParentheses > 0) {
            solution.append(')');
            openParentheses--;
        }

        System.out.println("Case #" + testCaseNumber + ": " + solution);
    }
}
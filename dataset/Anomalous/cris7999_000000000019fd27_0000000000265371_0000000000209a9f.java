import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            String digits = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char digit : digits.toCharArray()) {
                int num = Character.getNumericValue(digit);
                while (openParentheses < num) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > num) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            int closedBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (closedBrackets > digit) {
                    result.append(')');
                    closedBrackets--;
                    openBrackets--;
                }
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                    closedBrackets++;
                }
                result.append(ch);
            }

            while (closedBrackets-- > 0) {
                result.append(')');
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}
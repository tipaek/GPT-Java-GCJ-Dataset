import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int k = 0; k < n; k++) {
            String s = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = s.charAt(i) - '0';

                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(s.charAt(i));
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (k + 1) + ": " + result);
        }

        scanner.close();
    }
}
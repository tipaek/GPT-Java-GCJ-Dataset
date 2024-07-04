import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';

                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(currentDigit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            result.append("Case #").append(t + 1).append(": ");
            String input = scanner.nextLine();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                
                while (openBrackets < currentDigit) {
                    result.append("(");
                    openBrackets++;
                }
                
                while (openBrackets > currentDigit) {
                    result.append(")");
                    openBrackets--;
                }
                
                result.append(currentDigit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            result.append("\n");
        }

        System.out.print(result);
    }
}
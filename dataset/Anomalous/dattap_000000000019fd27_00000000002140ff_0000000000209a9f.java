import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                char previousChar = i > 0 ? input.charAt(i - 1) : '0';

                if (currentChar == '1' && (i == 0 || previousChar == '0')) {
                    result.append('(');
                    openBrackets++;
                }

                if (currentChar == '0' && previousChar == '1') {
                    result.append(')');
                    openBrackets--;
                }

                result.append(currentChar);

                if (currentChar == '1' && (i == input.length() - 1 || input.charAt(i + 1) == '0')) {
                    result.append(')');
                    openBrackets--;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }

        scanner.close();
    }
}
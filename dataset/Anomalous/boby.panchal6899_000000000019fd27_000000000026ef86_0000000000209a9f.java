import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
            processInput(input, i);
        }
        
        scanner.close();
    }

    private static void processInput(String input, int caseNumber) {
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

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}
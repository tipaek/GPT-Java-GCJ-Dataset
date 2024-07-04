import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            processCase(input, t);
        }
    }

    public static void processCase(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (currentDepth < digit) {
                result.append("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(")");
                currentDepth--;
            }
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}
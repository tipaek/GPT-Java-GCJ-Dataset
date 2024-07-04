import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            processString(inputString, i);
        }
    }

    private static void processString(String input, int caseNumber) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char character : input.toCharArray()) {
            int digit = character - '0';
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(character);
        }
        
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }
        
        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}
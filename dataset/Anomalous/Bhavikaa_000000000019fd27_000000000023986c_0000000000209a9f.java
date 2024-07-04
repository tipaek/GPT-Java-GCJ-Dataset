import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            processString(inputString, t);
        }
    }

    public static void processString(String input, int caseNumber) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char character : input.toCharArray()) {
            int digit = character - '0';
            while (digit > currentDepth) {
                result.append("(");
                currentDepth++;
            }
            while (digit < currentDepth) {
                result.append(")");
                currentDepth--;
            }
            result.append(character);
        }
        
        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        System.out.println(String.format("Case #%d: %s", caseNumber, result.toString()));
    }
}
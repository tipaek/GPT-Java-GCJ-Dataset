import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + formatStringWithParentheses(input));
        }
    }

    private static String formatStringWithParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            
            while (currentDepth < number) {
                result.append("(");
                currentDepth++;
            }
            
            while (currentDepth > number) {
                result.append(")");
                currentDepth--;
            }
            
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        return result.toString();
    }
}
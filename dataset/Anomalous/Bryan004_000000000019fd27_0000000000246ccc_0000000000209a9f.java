import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + processInput(input));
        }
        
        scanner.close();
    }

    private static String processInput(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;
        
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            
            while (currentDepth < digit) {
                result.append("(");
                currentDepth++;
            }
            
            while (currentDepth > digit) {
                result.append(")");
                currentDepth--;
            }
            
            result.append(digit);
        }
        
        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }
        
        return result.toString();
    }
}
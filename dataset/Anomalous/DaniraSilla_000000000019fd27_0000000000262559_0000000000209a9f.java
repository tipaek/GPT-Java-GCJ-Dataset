import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                
                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }
                
                result.append(digit);
            }
            
            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}
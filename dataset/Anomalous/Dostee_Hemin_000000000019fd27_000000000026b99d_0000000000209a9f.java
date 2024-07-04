import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder resultString = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentDepth < digit) {
                    resultString.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    resultString.append(')');
                    currentDepth--;
                }
                
                resultString.append(digit);
            }
            
            while (currentDepth > 0) {
                resultString.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + resultString);
        }
        
        scanner.close();
    }
}
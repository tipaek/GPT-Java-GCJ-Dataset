import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder outputBuilder = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentDepth < digit) {
                    outputBuilder.append("(");
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    outputBuilder.append(")");
                    currentDepth--;
                }
                
                outputBuilder.append(digit);
            }
            
            while (currentDepth > 0) {
                outputBuilder.append(")");
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + outputBuilder);
        }
        
        scanner.close();
    }
}
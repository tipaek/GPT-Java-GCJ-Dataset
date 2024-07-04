import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < inputString.length(); i++) {
                int digit = Character.getNumericValue(inputString.charAt(i));
                
                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        result.append('(');
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        result.append(')');
                    }
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}
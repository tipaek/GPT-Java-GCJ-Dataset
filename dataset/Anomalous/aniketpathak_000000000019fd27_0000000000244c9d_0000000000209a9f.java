import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int t = 1; t <= testCaseCount; ++t) {
            String inputString = scanner.next();
            int length = inputString.length();
            
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (int i = 0; i < length; ++i) {
                int currentDigit = inputString.charAt(i) - '0';
                
                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }
                
                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }
                
                result.append(inputString.charAt(i));
            }
            
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        scanner.close();
    }
}
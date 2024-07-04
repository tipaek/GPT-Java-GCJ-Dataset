import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                
                result.append(ch);
            }
            
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }
}
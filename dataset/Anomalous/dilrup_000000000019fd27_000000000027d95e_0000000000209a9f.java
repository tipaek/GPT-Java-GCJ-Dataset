import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String number = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentOpenParentheses = 0;
            
            for (int i = 0; i < number.length(); i++) {
                int digit = number.charAt(i) - '0';
                
                while (currentOpenParentheses < digit) {
                    result.append('(');
                    currentOpenParentheses++;
                }
                
                while (currentOpenParentheses > digit) {
                    result.append(')');
                    currentOpenParentheses--;
                }
                
                result.append(digit);
            }
            
            while (currentOpenParentheses > 0) {
                result.append(')');
                currentOpenParentheses--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                
                result.append(ch);
            }
            
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        
        for (int numTestCase = 1; numTestCase <= numTestCases; numTestCase++) {
            String digits = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (char ch : digits.toCharArray()) {
                int digit = ch - '0';
                
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                
                result.append(digit);
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.println("Case #" + numTestCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}